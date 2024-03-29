package _23_PastExams._2022_04_April_18.zoo.entities.areas;

import _23_PastExams._2022_04_April_18.zoo.entities.animals.Animal;
import _23_PastExams._2022_04_April_18.zoo.entities.foods.Food;

import java.util.Collection;

public interface Area {
    String getName();

    Collection<Animal> getAnimals();

    Collection<Food> getFoods();

    int sumCalories();

    void addAnimal(Animal animal);

    void removeAnimal(Animal animal);

    void addFood(Food food);

    void feed();

    String getInfo();
}
