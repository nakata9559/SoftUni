package _23_PastExams._2021_12_December_20.christmasRaces.repositories;

import _23_PastExams._2021_12_December_20.christmasRaces.repositories.interfaces.Repository;
import _23_PastExams._2021_12_December_20.christmasRaces.entities.races.Race;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RaceRepository implements Repository<Race> {
    private Collection<Race> models;

    public RaceRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) {
        return this.models.stream()
                .filter(model -> model.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Race model) {
        this.models.add(model);
    }

    @Override
    public boolean remove(Race model) {
        return this.models.remove(model);
    }
}
