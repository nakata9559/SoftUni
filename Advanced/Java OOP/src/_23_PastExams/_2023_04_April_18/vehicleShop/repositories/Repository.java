package _23_PastExams._2023_04_April_18.vehicleShop.repositories;

import java.util.Collection;

public interface Repository<T> {
    Collection<T> getWorkers();

    void add(T model);

    boolean remove(T model);

    T findByName(String name);
}
