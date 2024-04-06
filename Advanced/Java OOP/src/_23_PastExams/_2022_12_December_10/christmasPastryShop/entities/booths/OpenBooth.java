package _23_PastExams._2022_12_December_10.christmasPastryShop.entities.booths;

public class OpenBooth extends BaseBooth{
    private static final double PRICE_PER_PERSON = 2.5;

    public OpenBooth(int boothNumber, int capacity) {
        super(boothNumber, capacity, PRICE_PER_PERSON);
    }
}
