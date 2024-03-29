package _23_PastExams._2023_12_December_19.climbers.repositories;

import _23_PastExams._2023_12_December_19.climbers.models.climber.Climber;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ClimberRepository<T> implements Repository<Climber> {
    private Collection<Climber> climbers;

    public ClimberRepository() {
        this.climbers = new ArrayList<>();
    }

    @Override
    public Collection<Climber> getCollection() {
        return Collections.unmodifiableCollection(this.climbers);
    }

    @Override
    public void add(Climber entity) {
        this.climbers.add(entity);
    }

    @Override
    public boolean remove(Climber entity) {
        return this.climbers.remove(entity);
    }

    @Override
    public Climber byName(String name) {
        return this.climbers.stream()
                .filter(climber -> climber.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
