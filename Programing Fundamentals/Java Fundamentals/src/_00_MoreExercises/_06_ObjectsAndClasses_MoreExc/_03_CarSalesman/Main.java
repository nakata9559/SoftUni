package _00_MoreExercises._06_ObjectsAndClasses_MoreExc._03_CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();
        List<Engine> engines = new ArrayList<>();

        int numOfEngines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfEngines; i++) {
            String[] engineData = scanner.nextLine().split(" ");

            Engine eachEngine = getEachEngine(engineData);

            engines.add(eachEngine);
        }

        int numOfCars = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfCars; i++) {
            String[] carData = scanner.nextLine().split(" ");
            Car eachCar = getEachCar(engines, carData);

            cars.add(eachCar);
        }

        for (Car car : cars) {
            System.out.print(car);
        }
    }

    private static Car getEachCar(List<Engine> engines, String[] carData) {
        List<Engine> eachCarEngine = new ArrayList<>();

        for (Engine engine : engines) {
            if (carData[1].equals(engine.getModel())) {
                eachCarEngine = new ArrayList<>(engines);
                break;
            }
        }

        Car eachCar = new Car(carData[0], carData[1], eachCarEngine);

        if (carData.length == 4) {
            eachCar.setWeight(carData[2]);
            eachCar.setColor(carData[3]);

        } else if (carData.length == 3
                && carData[2].charAt(0) >= 'A'
                && carData[2].charAt(0) <= 'Z') {
            eachCar.setColor(carData[2]);

        } else if (carData.length == 3){
            eachCar.setWeight(carData[2]);
        }
        return eachCar;
    }

    private static Engine getEachEngine(String[] engineData) {
        Engine eachEngine = new Engine(engineData[0], engineData[1]);

        if (engineData.length == 4) {
            eachEngine.setDisplacement(engineData[2]);
            eachEngine.setEfficiency(engineData[3]);

        } else if (engineData.length == 3
                && engineData[2].charAt(0) >= 'A'
                && engineData[2].charAt(0) <= 'F') {
            eachEngine.setEfficiency(engineData[2]);

        } else if (engineData.length == 3){
            eachEngine.setDisplacement(engineData[2]);
        }
        return eachEngine;
    }
}
