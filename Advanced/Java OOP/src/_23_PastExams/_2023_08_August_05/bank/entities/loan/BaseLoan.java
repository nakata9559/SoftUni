package _23_PastExams._2023_08_August_05.bank.entities.loan;

public abstract class BaseLoan implements Loan{
    private int interestRate;
    private double amount;

    public BaseLoan(int interestRate, double amount) {
        this.interestRate = interestRate;
        this.amount = amount;
    }

    @Override
    public int getInterestRate() {
        return this.interestRate;
    }

    @Override
    public double getAmount() {
        return this.amount;
    }
}
