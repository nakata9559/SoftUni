package _04_Encapsulation_Exc._03_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void buyProduct(Product product) {
        if (product.getCost() <= this.money) {
            this.products.add(product);
            System.out.println(this.name + " bought " + product.getName());
            this.money -= product.getCost();
        } else {
            throw new IllegalArgumentException(this.name + " can't afford " + product.getName());
        }
    }

    @Override
    public String toString() {
        if (this.products.isEmpty()) {
            return this.name + " - Nothing bought";
        } else {
            return String.format("%s - %s",
                    this.name,
                    String.join(", ", this.products.stream()
                            .map(Product::getName)
                            .toArray(String[]::new)));
        }
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }
}
