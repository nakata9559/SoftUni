package _12_ObjectsAndClasses_Exc._07_GroomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {

    private int capacity;
    private List<Pet> data = new ArrayList<>();

    public int getCapacity() {
        return capacity;
    }

    public List<Pet> getData() {
        return data;
    }

    public GroomingSalon (int capacity) {
        this.capacity = capacity;
    }

    public int getCount() {
        return data.size();
    }

    public void add(Pet petToAdd) {
        if (data.size() < capacity) {
            data.add(petToAdd);
        }
    }

    public boolean remove(String name) {
        boolean exists = false;

        for (Pet pet : data) {
            if (pet.getName().equals(name)) {
                data.remove(pet);
                exists = true;
                break;
            }
        }

        return exists;
    }

    public Pet getPet(String name, String owner){
        Pet petToGet = null;

        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                petToGet = pet;
            }
        }

        return petToGet;
    }

    public String getStatistics() {
        String output = "The grooming salon has the following clients:\n";

        for (Pet pet : data) {
            output += String.format("%s %s\n",
                    pet.getName(),
                    pet.getOwner());

        }

        return output;
    }
}
