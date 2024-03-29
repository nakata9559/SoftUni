package _10_Polymorphism_Exc._02_VehiclesExtension;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        String[] truckInfo = scanner.nextLine().split("\\s+");
        String[] busInfo = scanner.nextLine().split("\\s+");

        Set<Vehicle> vehicles = new LinkedHashSet<>();

        vehicles.add(new Car(Double.parseDouble(carInfo[1]),
                Double.parseDouble(carInfo[2]),
                Double.parseDouble(carInfo[3])));

        vehicles.add(new Truck(Double.parseDouble(truckInfo[1]),
                Double.parseDouble(truckInfo[2]),
                Double.parseDouble(truckInfo[3])));

        vehicles.add(new Bus(Double.parseDouble(busInfo[1]),
                Double.parseDouble(busInfo[2]),
                Double.parseDouble(busInfo[3])));

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

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "DriveEmpty":
                    if ("_10_Polymorphism_Exc._02_VehiclesExtension.Bus".equals(vehicle)) {
                        try {
                            vehicles.stream()
                                    .filter(e -> e.getClass().getSimpleName().equals(vehicle))
                                    .forEach(e -> ((Bus) e).driveEmpty(token));

                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case "Refuel":
                    try {
                    vehicles.stream()
                            .filter(e -> e.getClass().getSimpleName().equals(vehicle))
                            .forEach(e -> e.refuel(token));

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }

        vehicles.forEach(System.out::println);
    }
}
