package _12_DefiningClasses_Exc._05_CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        int engineLines = Integer.parseInt(scanner.nextLine());

        while (engineLines-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            Engine engine = new Engine();

            switch (tokens.length) {
                case 2:
                    engine = new Engine(model, power);
                    break;

                case 3:
                    if (Character.isDigit(tokens[2].charAt(0))) {
                        int displacement = Integer.parseInt(tokens[2]);
                        engine = new Engine(model, power, displacement);

                    } else {
                        String efficiency = tokens[2];
                        engine = new Engine(model, power, efficiency);
                    }
                    break;

                case 4:
                    int displacement = Integer.parseInt(tokens[2]);
                    String efficiency = tokens[3];
                    engine = new Engine(model, power, displacement, efficiency);
                    break;
            }
            engines.add(engine);
        }

        int carLines = Integer.parseInt(scanner.nextLine());

        while (carLines-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            Engine engine = engines.stream()
                    .filter(e -> e.getModel().equals(tokens[1]))
                    .collect(Collectors.toList())
                    .get(0);

            Car car = new Car();

            switch (tokens.length) {
                case 2:
                    car = new Car(model, engine);
                    break;

                case 3:
                    if (Character.isDigit(tokens[2].charAt(0))) {
                        int weight = Integer.parseInt(tokens[2]);
                        car = new Car(model, engine, weight);

                    } else {
                        String color = tokens[2];
                        car = new Car(model, engine, color);
                    }
                    break;

                case 4:
                    int weight = Integer.parseInt(tokens[2]);
                    String color = tokens[3];
                    car = new Car(model, engine, weight, color);
                    break;
            }
            cars.add(car);
        }
        cars.forEach(System.out::println);
    }
}
