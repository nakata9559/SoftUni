package _23_PastExams._2022_12_December_10.christmasPastryShop.repositories;

import _23_PastExams._2022_12_December_10.christmasPastryShop.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class BaseRepository<T> implements Repository<T> {
    private Collection<T> models;

    public BaseRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<T> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(T t) {
        this.models.add(t);
    }
}
