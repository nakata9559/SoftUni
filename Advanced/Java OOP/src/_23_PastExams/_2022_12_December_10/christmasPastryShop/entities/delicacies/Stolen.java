package _23_PastExams._2022_12_December_10.christmasPastryShop.entities.delicacies;

public class Stolen extends BaseDelicacy{
    private static final double INITIAL_PORTION = 250;

    public Stolen(String name, double price) {
        super(name, INITIAL_PORTION, price);
    }
}
