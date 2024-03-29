package _23_PastExams._2022_04_April_18.zoo.entities.areas;

import _23_PastExams._2022_04_April_18.zoo.common.ExceptionMessages;
import _23_PastExams._2022_04_April_18.zoo.entities.animals.Animal;
import _23_PastExams._2022_04_April_18.zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseArea implements Area{
    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;

    public BaseArea(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return this.animals;
    }

    @Override
    public Collection<Food> getFoods() {
        return this.foods;
    }

    @Override
    public int sumCalories() {
        return this.getFoods()
                .stream()
                .mapToInt(Food::getCalories)
                .sum();
    }

    @Override
    public void addAnimal(Animal animal) {
        if (this.capacity > this.animals.size()) {
            this.animals.add(animal);
        } else {
            throw new IllegalStateException(ExceptionMessages.NOT_ENOUGH_CAPACITY);
        }
    }

    @Override
    public void removeAnimal(Animal animal) {
        this.animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        this.foods.add(food);
    }

    @Override
    public void feed() {
        this.animals.forEach(Animal::eat);
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s (%s):",
                this.getName(),
                this.getClass().getSimpleName()));
        sb.append(System.lineSeparator());

        sb.append("Animals: ");
        if (this.animals.isEmpty()) {
            sb.append("none");
        } else {
            sb.append(String.join(" ",
                    this.animals.stream()
                    .map(Animal::getName)
                    .toArray(String[]::new)));
        }
        sb.append(System.lineSeparator());

        sb.append(String.format("Foods: %d", this.foods.size()));
        sb.append(System.lineSeparator());

        sb.append(String.format("Calories: %d",
                this.foods.stream()
                        .mapToInt(Food::getCalories)
                        .sum()));

        return sb.toString();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.AREA_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }
}
