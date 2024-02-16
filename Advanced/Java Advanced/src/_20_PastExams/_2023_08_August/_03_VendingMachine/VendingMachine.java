package _20_PastExams._2023_08_August._03_VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
        this.drinks = new ArrayList<>();
    }

    public int getCount() {
        return drinks.size();
    }

    public void addDrink(Drink drink) {
        if (this.drinks.size() < buttonCapacity) {
            this.drinks.add(drink);
        }
    }

    public boolean removeDrink(String name) {
        for (Drink drink : this.drinks) {
            if (drink.getName().equals(name)) {
                this.drinks.remove(drink);
                return true;
            }
        }
        return false;
    }

    public Drink getLongest() {
        Drink longest = this.drinks.get(0);

        for (int i = 1; i < this.drinks.size(); i++) {
            if (this.drinks.get(i).getVolume() > longest.getVolume()) {
                longest = this.drinks.get(i);
            }
        }

        return longest;
    }

    public Drink getCheapest() {
        Drink cheapest = this.drinks.get(0);

        for (int i = 1; i < this.drinks.size(); i++) {
            if (this.drinks.get(i).getPrice().compareTo(cheapest.getPrice()) < 0) {
                cheapest = this.drinks.get(i);
            }
        }

        return cheapest;

    }

    public String buyDrink(String name) {
        String output = "";
        for (Drink drink : this.drinks) {
            if (drink.getName().equals(name)) {
                output = drink.toString();
                break;
            }
        }
        return output;
    }

    public String report() {
        StringBuilder sb = new StringBuilder("Drinks available:" + System.lineSeparator());

        for (Drink drink : this.drinks) {
            sb.append(drink).append(System.lineSeparator());
        }

        return String.valueOf(sb);
    }
}
