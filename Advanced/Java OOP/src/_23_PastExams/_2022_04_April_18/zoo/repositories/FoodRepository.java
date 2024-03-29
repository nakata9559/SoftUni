package _23_PastExams._2022_04_April_18.zoo.repositories;

import _23_PastExams._2022_04_April_18.zoo.entities.foods.Food;

public interface FoodRepository {
    void add(Food food);

    boolean remove(Food food);

    Food findByType(String type);
}
