package _11_DefiningClasses_Lab._03_BankAccount;

public class BankAccount {
    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int accountsCounter = 1;
    private int id;
    private double balance;

    BankAccount() {
        this.id = accountsCounter++;
    }

    public static void setInterestRate(double interest) {
        BankAccount.interestRate = interest;
    }

    public double getInterest(int years) {
        return BankAccount.interestRate * years * this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getID() {
        return id;
    }
}
