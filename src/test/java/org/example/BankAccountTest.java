package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount bankAccount;

    @BeforeEach
    void setup(){
        bankAccount = new BankAccount(1994, "Lee Ji Eun", 100);
    }

    @Test
    void depositValidAmount() {
        bankAccount.deposit(100);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    void depositInvalidAmount(){
        bankAccount.deposit(-10);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void withdrawValidAmount() {
        bankAccount.withdraw(10);
        assertEquals(90, bankAccount.getBalance());
    }

    @Test
    void withdrawInvalidAmount() {
        bankAccount.withdraw(0);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void withdrawExceedingBalance() {
        bankAccount.withdraw(1000);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void createAccNoDeposit() {
        BankAccount noDeposit = new BankAccount(2002, "John Pork");
        assertInstanceOf(BankAccount.class, noDeposit);
    }
}