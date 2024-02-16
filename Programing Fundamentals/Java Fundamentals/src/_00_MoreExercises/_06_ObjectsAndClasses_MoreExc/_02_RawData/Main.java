package _00_MoreExercises._06_ObjectsAndClasses_MoreExc._02_RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] inputDetails = scanner.nextLine().split(" ");

            String model = inputDetails[0];
            Car eachCar = getEachCar(inputDetails, model);
            cars.add(eachCar);
        }

        getCarByCommand(scanner.nextLine(), cars);
    }

    private static Car getEachCar(String[] inputDetails, String model) {
        String[] engineData = new String[] {inputDetails[1], inputDetails[2]};
        String[] cargoData = new String[] {inputDetails[3], inputDetails[4]};
        String[] tiresData = new String[] {inputDetails[5], inputDetails[6],
                inputDetails[7], inputDetails[8], inputDetails[9],
                inputDetails[10], inputDetails[11], inputDetails[12]};

        return new Car(model,
                engineData,
                cargoData,
                tiresData);
    }

    private static void getCarByCommand(String command, List<Car> cars) {
        switch (command) {
            case "fragile":
                for (Car car : cars) {
                    if (car.getMinTirePressure() < 1) {
                        System.out.println(car.getModel());
                    }
                }

                break;

            case "flamable":
                for (Car car : cars) {
                    if (car.getEnginePower() > 250) {
                        System.out.println(car.getModel());
                    }
                }

                break;
        }
    }
}