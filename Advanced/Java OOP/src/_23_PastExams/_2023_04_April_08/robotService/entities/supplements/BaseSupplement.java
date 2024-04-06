package _23_PastExams._2023_04_April_08.robotService.entities.supplements;

public abstract class BaseSupplement implements Supplement{
    private int hardness;
    private double price;

    public BaseSupplement(int hardness, double price) {
        this.hardness = hardness;
        this.price = price;
    }

    @Override
    public int getHardness() {
        return this.hardness;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
