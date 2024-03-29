package _23_PastExams._2022_08_August_22.goldDigger.repositories;

import _23_PastExams._2022_08_August_22.goldDigger.models.spot.Spot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SpotRepository implements Repository<Spot> {
    private Collection<Spot> spots;

    public SpotRepository() {
        this.spots = new ArrayList<>();
    }

    @Override
    public Collection<Spot> getCollection() {
        return Collections.unmodifiableCollection(this.spots);
    }

    @Override
    public void add(Spot entity) {
        if (!this.spots.contains(entity)) {
            this.spots.add(entity);
        }
    }

    @Override
    public boolean remove(Spot entity) {
        return this.spots.remove(entity);
    }

    @Override
    public Spot byName(String name) {
        return this.spots.stream()
                .filter(spot -> spot.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
