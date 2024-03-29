package _10_Polymorphism_Exc._01_Vehicles;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        String[] truckInfo = scanner.nextLine().split("\\s+");

        Set<Vehicle> vehicles = new LinkedHashSet<>();
        vehicles.add(new Car(Double.parseDouble(carInfo[1]),
                Double.parseDouble(carInfo[2])));
        vehicles.add(new Truck(Double.parseDouble(truckInfo[1]),
                Double.parseDouble(truckInfo[2])));

        int numOfCommands = Integer.parseInt(scanner.nextLine());

        while (numOfCommands-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            String vehicle = tokens[1];
            double token = Double.parseDouble(tokens[2]);

            switch (command) {
                case "Drive":
                    try {
                        vehicles.stream()
                                .filter(e -> e.getClass().getSimpleName().equals(vehicle))
                                .forEach(e -> e.drive(token));

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "Refuel":
                    vehicles.stream()
                            .filter(e -> e.getClass().getSimpleName().equals(vehicle))
                            .forEach(e -> e.refuel(token));
                    break;
            }
        }

        vehicles.forEach(System.out::println);
    }
}
