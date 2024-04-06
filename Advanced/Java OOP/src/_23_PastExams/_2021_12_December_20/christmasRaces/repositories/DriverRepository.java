package _23_PastExams._2021_12_December_20.christmasRaces.repositories;

import _23_PastExams._2021_12_December_20.christmasRaces.entities.drivers.Driver;
import _23_PastExams._2021_12_December_20.christmasRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DriverRepository implements Repository<Driver> {
    private Collection<Driver> models;

    public DriverRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Driver getByName(String name) {
        return this.models.stream()
                .filter(model -> model.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Driver model) {
        this.models.add(model);
    }

    @Override
    public boolean remove(Driver model) {
        return this.models.remove(model);
    }
}
