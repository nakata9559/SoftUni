package _23_PastExams._2023_08_August_05.bank.entities.client;

public class Student extends BaseClient{
    private static final int INITIAL_INTEREST = 2;

    public Student(String name, String ID, double income) {
        super(name, ID, INITIAL_INTEREST, income);
    }
}
