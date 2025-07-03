package org.example;

public class BankAccount {
    private int accNumber;
    private String accHolder;
    private double balance;

    public BankAccount(int accNumber, String name, double balance){
        this.accNumber = accNumber;
        this.accHolder = name;
        this.balance = balance;
    }

    public BankAccount(int accNumber, String name){
        this.accNumber = accNumber;
        this.accHolder = name;
        this.balance = 0;
    }

    public double deposit (double depositAmt) {
        if (depositAmt <= 0) {
            System.out.println("Please enter valid amount");
        } else {
            this.balance += depositAmt;
            System.out.println("Deposit of PHP" + depositAmt + " is successful");
            System.out.println("New balance: " + this.balance);
            return this.balance;
        }
        return 0.0;
    }

    public double withdraw (double withdrawAmt){
        if (withdrawAmt <= 0 || withdrawAmt > this.balance) {
            System.out.println("Please enter valid amount");
        } else {
            this.balance -= withdrawAmt;
            System.out.println("Withdrawal of PHP" + withdrawAmt + " is successful");
            System.out.println("New balance: " + this.balance);
            return this.balance;
        }
        return 0.0;
    }

    public void displayInfo(){
        System.out.println("Account Holder: " + this.accHolder);
        System.out.println("Account Number: " + this.accNumber);
        System.out.println("Available Balance: " + this.balance);
    }

    public int getAccNumber(){
        return this.accNumber;
    }

    public double getBalance(){
        return this.balance;
    }


}
