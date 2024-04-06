package _23_PastExams._2022_12_December_10.christmasPastryShop.entities.booths;

import _23_PastExams._2022_12_December_10.christmasPastryShop.entities.booths.interfaces.Booth;
import _23_PastExams._2022_12_December_10.christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import _23_PastExams._2022_12_December_10.christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

import static _23_PastExams._2022_12_December_10.christmasPastryShop.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static _23_PastExams._2022_12_December_10.christmasPastryShop.common.ExceptionMessages.INVALID_TABLE_CAPACITY;

public abstract class BaseBooth implements Booth {
    private Collection<Delicacy> delicacyOrders;
    private Collection<Cocktail> cocktailOrders;
    private int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
        this.boothNumber = boothNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.delicacyOrders = new ArrayList<>();
        this.cocktailOrders = new ArrayList<>();
    }

    @Override
    public int getBoothNumber() {
        return this.boothNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.setNumberOfPeople(numberOfPeople);
        this.price = this.pricePerPerson * numberOfPeople;
        this.isReserved = true;
    }

    @Override
    public double getBill() {
        return this.price;
    }

    @Override
    public void clear() {
        this.cocktailOrders.clear();
        this.delicacyOrders.clear();
        this.isReserved = false;
        this.numberOfPeople = 0;
        this.price = 0;
    }

    private void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }

        this.capacity = capacity;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }

        this.numberOfPeople = numberOfPeople;
    }
}
