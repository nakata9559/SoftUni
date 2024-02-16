package _00_MoreExercises._10_FinalExamPreparation._03_;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _03_NeedForSpeed_III {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfCars = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> carMileage = new LinkedHashMap<>();
        Map<String, Integer> carFuel = new LinkedHashMap<>();

        for (int i = 0; i < numOfCars; i++) {
            String[] input = scanner.nextLine().split("\\|");

            String car = input[0];
            int mileage = Integer.parseInt(input[1]);
            int fuel = Integer.parseInt(input[2]);

            carMileage.put(car, mileage);
            carFuel.put(car, fuel);
        }

        while (true) {
            String[] command = scanner.nextLine().split(" : ");
            if (command[0].equals("Stop")) {
                break;
            }

            String car = command[1];

            switch (command[0]) {
                case "Drive":
                    int distance = Integer.parseInt(command[2]);
                    int fuel = Integer.parseInt(command[3]);

                    if (carFuel.get(car) < Integer.parseInt(command[3])) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        carMileage.replace(car, carMileage.get(car) + distance);
                        carFuel.replace(car, carFuel.get(car) - fuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.\n", car, distance, fuel);
                    }

                    if (carMileage.get(car) >= 100000) {
                        System.out.printf("Time to sell the %s!\n", car);
                        carFuel.remove(car);
                        carMileage.remove(car);
                    }
                    break;

                case "Refuel":
                    int refuel = Integer.parseInt(command[2]);
                    int filled;

                    if (carFuel.get(car) + refuel <= 75) {
                        carFuel.replace(car, carFuel.get(car) + refuel);
                        filled = refuel;
                    } else {
                        filled = 75 - carFuel.get(car);
                        carFuel.replace(car, 75);
                    }

                    System.out.printf("%s refueled with %d liters\n", car, filled);

                    break;

                case "Revert":
                    int kilometers = Integer.parseInt(command[2]);
                    if (carMileage.get(car) - kilometers < 10000) {
                        carMileage.replace(car, 10000);
                    } else {
                        carMileage.replace(car, carMileage.get(car) - kilometers);
                        System.out.printf("%s mileage decreased by %d kilometers\n", car, kilometers);
                    }

                    break;
            }
        }

        carFuel.forEach((key, value) -> {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.\n",
                    key, carMileage.get(key), value);
        });
    }
}
