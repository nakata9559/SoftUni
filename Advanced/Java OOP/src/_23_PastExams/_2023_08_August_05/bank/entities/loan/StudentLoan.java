package _23_PastExams._2023_08_August_05.bank.entities.loan;

public class StudentLoan extends BaseLoan{
    private static final int INTEREST_RATE = 1;
    private static final double AMOUNT = 10_000;

    public StudentLoan() {
        super(INTEREST_RATE, AMOUNT);
    }
}
