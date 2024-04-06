package _23_PastExams._2022_12_December_10.christmasPastryShop.entities.delicacies;

public class Gingerbread extends BaseDelicacy{
    private static final double INITIAL_PORTION = 200;

    public Gingerbread(String name, double price) {
        super(name, INITIAL_PORTION, price);
    }
}
