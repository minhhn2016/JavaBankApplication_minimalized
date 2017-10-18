package JavaBankApplication;
// ************************************************************************
// BankProgram.java	15.9.2016
// - The program class for the BankApplication exercise
// ************************************************************************

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class BankProgram {

    private static List<Account> accountList = new ArrayList<Account>();

    // *** DO NOT change anything in the main method ***
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {

            switch (choice) {
                case 1:
                    listAccounts();
                    break;
                case 2:
                    addAccount();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    withdrawMoney();
                    break;
                case 5:
                    deleteAccount();
                    break;
            }

            displayMenu();
            choice = input.nextInt();
        }

        System.out.println("\nThe program ends now. Bye!");
    }

    private static void displayMenu() {
        String line = "-----------------------------------------------------" +
                "---------------------------------------------------------------";
        System.out.println(line);
        System.out.print(" 0 = Quit | 1 = List accounts | 2 = Add an account | " +
                "3 = Deposit money | 4 = Withdraw money | 5 = Delete an account \n");
        System.out.println(line);
        System.out.print("Enter your choice: ");
    }

    // *** NB! Edit only the methods below. DO NOT add any other methods! ***

    private static void listAccounts() {
        System.out.print("\n*** Account list ***\n");
        for (Account account : accountList
                ) {
            System.out.println("Number: " + account.getAccountNumber()
                    + " | Balance: " + account.getBalance() + " euros");
        }
    }

    private static void addAccount() {
        Scanner input = new Scanner(System.in);
        System.out.print("\n*** Add an account ***\n");
        System.out.println("Enter account number: ");
        String accountNumber = input.nextLine();
        if (findAccount(accountNumber) == null) {
            Account newAccount = new Account(accountNumber);
            accountList.add(newAccount);
            System.out.println("Account created successfully!");
        }
        else {
            System.out.println("Account " + accountNumber + " is already exists!");
        }

    }

    // Finds an account in accountList by given account number
    // Returns either the index of the account object in the account list
    // OR -1 if the account is not found.
    private static Account findAccount(String accountNumber) {
        Account myAccount = null;
        for (Account account : accountList
                ) {
            if (accountNumber.equals(account.getAccountNumber())) {
                myAccount = account;
                break;
            }
        }
        return myAccount;
    }

    private static void depositMoney() {
        Scanner input = new Scanner(System.in);
        System.out.print("\n*** Deposit money to an account ***\n");
        System.out.println("Enter account number: ");
        String accountNumber = input.nextLine();
        if (findAccount(accountNumber) == null) {
            System.out.println("Account " + accountNumber + " does not exist!");

        } else {
            System.out.println("Enter the amount to be deposited: ");
            double amount = Double.parseDouble(input.nextLine());
            if (amount > 0) {
                findAccount(accountNumber).deposit(amount);
                System.out.println("Deposit completed successfully!");
            } else {
                System.out.println("Cannot deposit a negative amount!");
            }
        }
    }

    private static void withdrawMoney() {
        Scanner input = new Scanner(System.in);
        System.out.print("\n*** Withdraw money from an account ***\n");
        System.out.println("Enter account number: ");
        String accountNumber = input.nextLine();
        if (findAccount(accountNumber) == null) {
            System.out.println("Account " + accountNumber + " does not exist!");

        } else {
            System.out.println("Enter the amount to be withdrawn: ");
            double amount = Double.parseDouble(input.nextLine());
            boolean canWithdraw = findAccount(accountNumber).withdraw(amount);
            if (amount > 0) {
                if (!canWithdraw) {
                    System.out.println("Withdrawal not completed. Available balance is too low.");
                } else {
                    System.out.println("Withdrawal completed successfully!");
                }
            } else {
                System.out.println("Cannot withdraw a negative amount!");
            }
        }
    }

    private static void deleteAccount() {
        Scanner input = new Scanner(System.in);
        System.out.print("\n*** Delete an account ***\n");
        System.out.println("Enter account number: ");
        String accountNumber = input.nextLine();
        if (findAccount(accountNumber) == null) {
            System.out.println("Nothing deleted. Account " + accountNumber + " does not exists!");
        } else {
            accountList.remove(findAccount(accountNumber));
            System.out.println("Account deleted successfully!");

        }
    }
}
// End 
