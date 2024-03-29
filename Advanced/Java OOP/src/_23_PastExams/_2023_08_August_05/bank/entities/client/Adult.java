package _23_PastExams._2023_08_August_05.bank.entities.client;

public class Adult extends BaseClient{
    private static final int INITIAL_INTEREST = 4;

    public Adult(String name, String ID, double income) {
        super(name, ID, INITIAL_INTEREST, income);
    }

    @Override
    public void increase() {
        super.increase();
        super.increase();
    }
}
