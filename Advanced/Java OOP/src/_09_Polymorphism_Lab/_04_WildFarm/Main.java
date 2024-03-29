package _09_Polymorphism_Lab._04_WildFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split("\\s+");

        while (!"End".equals(firstLine[0])) {
            Animal animal = makeNewAnimal(firstLine);
            Food food = makeNewFood(scanner.nextLine().split("\\s+"));

            try {
                animal.makeSound();
                animal.eat(food);
                System.out.println(animal);

            } catch (NullPointerException ignored) {}

            firstLine = scanner.nextLine().split("\\s+");
        }
    }

    public static Animal makeNewAnimal(String[] inputLine) {
        String animalType = inputLine[0];
        String animalName = inputLine[1];
        Double animalWeight = Double.parseDouble(inputLine[2]);
        String animalLivingRegion = inputLine[3];

        switch (animalType) {
            case "_09_Polymorphism_Lab._04_WildFarm.Mouse":
                return new Mouse(animalType, animalName, animalWeight, animalLivingRegion);

            case "_09_Polymorphism_Lab._04_WildFarm.Cat":
                String breed = inputLine[4];
                return new Cat(animalType, animalName, animalWeight, animalLivingRegion, breed);

            case "_09_Polymorphism_Lab._04_WildFarm.Tiger":
                return new Tiger(animalType, animalName, animalWeight, animalLivingRegion);

            case "_09_Polymorphism_Lab._04_WildFarm.Zebra":
                return new Zebra(animalType, animalName, animalWeight, animalLivingRegion);

            default:
                return null;
        }
    }

    public static Food makeNewFood (String[] inputLine) {
        String foodType = inputLine[0];
        Integer foodQuantity = Integer.parseInt(inputLine[1]);

        switch (foodType) {
            case "_09_Polymorphism_Lab._04_WildFarm.Vegetable":
                return new Vegetable(foodQuantity);

            case "_09_Polymorphism_Lab._04_WildFarm.Meat":
                return new Meat(foodQuantity);

            default:
                return null;
        }
    }
}
