package _23_PastExams._2022_12_December_10.christmasPastryShop.entities.cocktails;

import _23_PastExams._2022_12_December_10.christmasPastryShop.entities.cocktails.interfaces.Cocktail;

import static _23_PastExams._2022_12_December_10.christmasPastryShop.common.ExceptionMessages.*;

public abstract class BaseCocktail implements Cocktail {
    private String name;
    private int size;
    private double price;
    private String brand;

    public BaseCocktail(String name, int size, double price, String brand) {
        this.setName(name);
        this.setSize(size);
        this.setPrice(price);
        this.setBrand(brand);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    @Override
    public String toString() {
        return String.format("%s %s - %dml - %.2flv",
                this.name,
                this.brand,
                this.size,
                this.price);
    }

    private void setName(String name) {
        if (null == name || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME);
        }

        this.name = name;
    }

    private void setSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(INVALID_SIZE);
        }

        this.size = size;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }

        this.price = price;
    }

    private void setBrand(String brand) {
        if (null == brand || brand.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_BRAND);
        }

        this.brand = brand;
    }
}
