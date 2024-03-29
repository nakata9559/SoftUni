package _04_Encapsulation_Exc._04_PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numOfToppings;

    public Pizza(String name, int numOfToppings) {
        this.setName(name);
        this.setToppings(numOfToppings);
        this.numOfToppings = numOfToppings;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    public void addTopping(Topping topping) {
        if (this.numOfToppings-- > 0) {
            this.toppings.add(topping);
        }
    }

    public double getOverallCalories() {
        double toppingsCalories = this.toppings.stream()
                .mapToDouble(Topping::calculateCalories)
                .sum();

        return this.dough.calculateCalories() + toppingsCalories;
    }

    private void setToppings(int numOfToppings) {
        if (numOfToppings < 0 || numOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range[0..10].");
        }
        this.toppings = new ArrayList<>(numOfToppings);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }
}
