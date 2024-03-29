package _06_Inheritance_Exc._06_Animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();

        String type = scanner.nextLine();

        while (!"Beast!".equals(type)) {
            String[] tokens = scanner.nextLine().split("\\s+");

            addAnimal(type, tokens, animals);

            type = scanner.nextLine();
        }

        animals.forEach(System.out::println);
    }

    public static void addAnimal(String type, String[] tokens, List<Animal> animals) {
        String name = tokens[0];
        int age = Integer.parseInt(tokens[1]);
        String gender = tokens[2];

        try {
            animals.add(createAnimal(type, name, age, gender));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static <T> Animal createAnimal(String type, String name, int age, String gender) {
        switch (type) {
            case "_09_Polymorphism_Lab._03_Animals.Dog":
                return new Dog(name, age, gender);
            case "_09_Polymorphism_Lab._03_Animals._09_Polymorphism_Lab._04_WildFarm.Cat":
                return new Cat(name, age, gender);
            case "Frog":
                return new Frog(name, age, gender);
            case "Kitten":
                return new Kitten(name, age);
            case "Tomcat":
                return new Tomcat(name, age);
            default:
                throw new IllegalArgumentException("Invalid input!");
        }
    }
}
