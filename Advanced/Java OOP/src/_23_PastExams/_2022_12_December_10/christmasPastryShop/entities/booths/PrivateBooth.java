package _23_PastExams._2022_12_December_10.christmasPastryShop.entities.booths;

public class PrivateBooth extends BaseBooth{
    private static final double PRICE_PER_PERSON = 3.5;


    public PrivateBooth(int boothNumber, int capacity) {
        super(boothNumber, capacity, PRICE_PER_PERSON);
    }
}
