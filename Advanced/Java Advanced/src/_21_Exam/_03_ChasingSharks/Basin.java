package _21_Exam._03_ChasingSharks;

import java.util.*;

public class Basin {
    private String name;
    private int capacity;
    private List<Shark> sharks;

    public Basin(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.sharks = new ArrayList<>();
    }

    public void addShark(Shark shark) {
        if (this.capacity > this.sharks.size()) {
            this.sharks.add(shark);
        } else {
            System.out.println("This basin is at full capacity!");
        }
    }

    public boolean removeShark(String kind) {
        return this.sharks.removeIf(shark -> shark.getKind().equals(kind));
    }

    public Shark getLargestShark() {
        return this.sharks.stream()
                .max(Comparator.comparing(Shark::getLength))
                .orElse(null);
    }

    public Shark getShark(String kind) {
        return this.sharks.stream()
                .filter(shark -> shark.getKind().equals(kind))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.sharks.size();
    }

    public int getAverageLength() {
        return (int) this.sharks
                .stream()
                .mapToDouble(Shark::getLength)
                .average()
                .orElse(0.0);
    }

    public String report() {
        return String.format("Sharks in %s:%n" +
                "%s",
                this.name,
                String.join(System.lineSeparator(),
                        this.sharks.stream()
                                .map(String::valueOf)
                                .toArray(String[]::new)));
    }
}
