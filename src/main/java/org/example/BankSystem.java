package org.example;

import java.util.*;

public class BankSystem {

    public static void checkBalance(ArrayList<BankAccount> bankAccounts, int newAccNum){
        boolean exists = false;
        for (BankAccount account : bankAccounts){
            if (account.getAccNumber() == newAccNum) {
                account.displayInfo();
                exists = true;
                break;
            }
        }

        if(!exists){
            System.out.println("Account does not exist");
        }
    }

    public static void deposit (ArrayList<BankAccount> bankAccounts, int accNum, double depositAmt){
        boolean exists = false;
        for (BankAccount account : bankAccounts){
            if (account.getAccNumber() == accNum) {
                account.deposit(depositAmt);
                exists = true;
                break;
            }

        }

        if(!exists){
            System.out.println("Account does not exist");
        }
    }

    public static void createAccount(ArrayList<BankAccount> bankAccounts, int newAccNum, String name, double initBal){
        boolean exists = false;
        for (BankAccount accounts : bankAccounts){
            if (accounts.getAccNumber() == newAccNum) {
                System.out.println("Account number taken, please enter a different number");
                exists = true;
                break;
            }
        }

        if(!exists){
            bankAccounts.add(new BankAccount(newAccNum, name, initBal));
            System.out.println("Account created successfully!");
        }
        else System.out.println("Unsuccessful account creation, please try again.");
    }

    public static void viewAllAccounts(ArrayList<BankAccount> accounts){
        for(int i = 0; i < accounts.size(); i++){
            System.out.println("Account " + (i+1) + ":");
            accounts.get(i).displayInfo();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        int menuChoice = 0;

        System.out.println("1. Create Account");
        System.out.println("2. View All Accounts");
        System.out.println("3. Check Balance");
        System.out.println("4. Deposit");
        System.out.println("5. Withdraw");
        System.out.println("6. Exit");

        while(menuChoice != 6){
            System.out.print("Enter choice (1-6): ");
            menuChoice = sc.nextInt();
            sc.nextLine();

            switch(menuChoice){
                case 1:
                    System.out.print("Enter new account number: ");
                    int inAccNum = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Holder Name: ");
                    String inHolderName = sc.nextLine();
                    System.out.print("Initial deposit? (yes or no): ");
                    String ynDeposit = sc.nextLine();
                    switch (ynDeposit.toLowerCase()){
                        case "yes":
                            System.out.print("Enter initial deposit: ");
                            double initDeposit = sc.nextDouble(); //ADD INPUT CHECKING
                            createAccount(bankAccounts, inAccNum, inHolderName, initDeposit);
                            break;
                        case "no":
                            createAccount(bankAccounts, inAccNum, inHolderName, 0);
                            break;
                        default:
                            System.out.println("Invalid input, please try again");
                    }
                    break;

                case 2:
                    System.out.println("---");
                    viewAllAccounts(bankAccounts);
                    System.out.println("---");
                    break;
                case 3:
                    System.out.print("Enter account number to check balance: ");
                    inAccNum = sc.nextInt();
                    sc.nextLine();
                    checkBalance(bankAccounts, inAccNum);
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Enter account number to deposit to: ");
                    inAccNum = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter amount to deposit: ");
                    double depositAmt = sc.nextDouble();
                    deposit(bankAccounts, inAccNum, depositAmt);
                    break;




                case 6:
                    System.out.println("Thank you for banking with us!");
                    break;




            }
        }

    }
}