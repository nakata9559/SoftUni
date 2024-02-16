package _20_PastExams._2022_02_February._03_Parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (this.capacity > this.data.size()) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(parrot -> parrot.getName().equals(name));
    }

    public Parrot sellParrot(String name) {
        return this.data.stream()
                .filter(parrot -> {
                    if (parrot.getName().equals(name)) {
                        this.data.get(this.data.indexOf(parrot)).setAvailable(false);
                        return true;
                    } else {
                        return false;
                    }
                })
                .findFirst()
                .orElse(null);
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        return this.data.stream()
                .filter(e -> {
                    if (e.getSpecies().equals(species)) {
                        this.data.get(this.data.indexOf(e)).setAvailable(false);
                        return true;
                    } else {
                        return false;
                    }
                })
                .collect(Collectors.toList());
    }

    public int count(){
        return this.data.size();
    }

    public String report() {
        return String.format("Parrots available at %s:%n" +
                "%s",
                this.name,
                String.join(System.lineSeparator(),
                        this.data.stream()
                        .filter(Parrot::isAvailable)
                                .map(String::valueOf)
                                .toArray(String[]::new)));
    }
}
