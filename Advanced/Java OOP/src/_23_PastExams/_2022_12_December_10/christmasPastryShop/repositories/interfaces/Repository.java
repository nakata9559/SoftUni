package _23_PastExams._2022_12_December_10.christmasPastryShop.repositories.interfaces;

import java.util.Collection;

public interface Repository<T> {

    Collection<T> getAll();

    void add(T t);

}
