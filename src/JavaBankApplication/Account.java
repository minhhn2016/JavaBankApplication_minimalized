package JavaBankApplication;
// ************************************************************************
// Account.java	15.9.2016
// - The class for Account objects
// ************************************************************************
public class Account {
	// Fields

	private String accountNumber;
	private double balance;

	// Constructor

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Methods

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public boolean withdraw(double amount) {
        double tempBalance = balance - amount;
        if (tempBalance < 0) {
            return false;
        }
        else {
            balance = tempBalance;
            return true;
        }
    }
}
// End