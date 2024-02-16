package _20_PastExams._2022_04_April._03_EasterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {
    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (this.capacity > this.data.size()) {
            this.data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        for (Egg egg : this.data) {
            if (egg.getColor().equals(color)) {
                this.data.remove(egg);
                return true;
            }
        }
        return false;
    }

    public Egg getStrongestEgg() {
        return this.data.stream()
                .max(Comparator.comparing(Egg::getStrength))
                .orElse(null);
    }

    public Egg getEgg(String color) {
        for (Egg egg : this.data) {
            if (egg.getColor().equals(color)) {
                return egg;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
        return String.format("%s basket contains:%n" +
                "%s",
                this.material,
                String.join(System.lineSeparator(), this.data.stream()
                        .map(String::valueOf)
                        .toArray(String[]::new)));
    }
}
