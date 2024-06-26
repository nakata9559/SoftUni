package _23_PastExams._2023_04_April_08.robotService.repositories;

import _23_PastExams._2023_04_April_08.robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;

public class SupplementRepository implements Repository{
    private Collection<Supplement> supplements;

    public SupplementRepository() {
        this.supplements = new ArrayList<>();
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public boolean removeSupplement(Supplement supplement) {
        return this.supplements.remove(supplement);
    }

    @Override
    public Supplement findFirst(String type) {
        return this.supplements.stream()
                .filter(supplement -> supplement.getClass().getSimpleName().equals(type))
                .findFirst()
                .orElse(null);
    }
}
