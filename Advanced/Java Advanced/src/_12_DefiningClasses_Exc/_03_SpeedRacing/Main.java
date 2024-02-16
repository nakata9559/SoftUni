package _12_DefiningClasses_Exc._03_SpeedRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> carsList = new ArrayList<>();

        int inputLines = Integer.parseInt(scanner.nextLine());

        while (inputLines-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCostPerKilometer = Double.parseDouble(tokens[2]);

            Car car = new Car(model,
                    fuelAmount,
                    fuelCostPerKilometer);

            carsList.add(car);
        }

        String[] tokens = scanner.nextLine().split("\\s+");

        while (!"End".equals(tokens[0])) {
            String model = tokens[1];
            int distanceTraveled = Integer.parseInt(tokens[2]);

            carsList.stream()
                    .filter(e -> e.getModel().equals(model))
                    .forEach(e -> {
                        if (e.getFuelAmount() >= e.getFuelCostPerKilometer() * distanceTraveled) {
                            e.setFuelAmount(e.getFuelAmount() - e.getFuelCostPerKilometer() * distanceTraveled);
                            e.setDistanceTraveled(e.getDistanceTraveled() + distanceTraveled);

                        } else {
                            System.out.println("Insufficient fuel for the drive");
                        }
                    });
            tokens = scanner.nextLine().split("\\s+");
        }

        carsList.forEach(Car::printCarDetails);
    }
}
