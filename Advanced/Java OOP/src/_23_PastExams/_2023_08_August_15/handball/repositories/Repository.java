package _23_PastExams._2023_08_August_15.handball.repositories;

import _23_PastExams._2023_08_August_15.handball.entities.equipment.Equipment;

public interface Repository {
    void add(Equipment equipment);
    boolean remove(Equipment equipment);
    Equipment findByType(String type);
}
