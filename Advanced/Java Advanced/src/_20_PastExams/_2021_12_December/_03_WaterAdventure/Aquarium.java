package _20_PastExams._2021_12_December._03_WaterAdventure;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public void add(Fish fish) {
        if (this.capacity > this.fishInPool.size()) {
            boolean addIt = true;
            for (Fish fishInPool : this.fishInPool) {
                if (fishInPool.getName().equals(fish.getName())) {
                    addIt = false;
                    break;
                }
            }
            if (addIt) {
                this.fishInPool.add(fish);
            }
        }
    }

    public boolean remove(String name) {
        for (Fish fish : this.fishInPool) {
            if (fish.getName().equals(name)) {
                this.fishInPool.remove(fish);
                return true;
            }
        }
        return false;
    }

    public Fish findFish(String name) {
        for (Fish fish : this.fishInPool) {
            if (fish.getName().equals(name)) {
                return fish;
            }
        }

        return null;
    }

    public String report() {
        return String.format("Aquarium: %s ^ Size: %d%n" +
                        "%s",
                this.name,
                this.size,
                String.join(System.lineSeparator(),
                        this.fishInPool.stream()
                                .map(String::valueOf)
                                .toArray(String[]::new)));
    }
}
