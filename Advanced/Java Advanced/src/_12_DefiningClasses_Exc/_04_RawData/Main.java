package _12_DefiningClasses_Exc._04_RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        while (lines-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            Engine engine = new Engine(Integer.parseInt(tokens[1]),
                    Integer.parseInt(tokens[2]));
            Cargo cargo = new Cargo(Integer.parseInt(tokens[3]),
                    tokens[4]);
            Tire tires = new Tire(Double.parseDouble(tokens[5]),
                    Integer.parseInt(tokens[6]),
                    Double.parseDouble(tokens[7]),
                    Integer.parseInt(tokens[8]),
                    Double.parseDouble(tokens[9]),
                    Integer.parseInt(tokens[10]),
                    Double.parseDouble(tokens[11]),
                    Integer.parseInt(tokens[12]));

            Car car = new Car(model,
                    engine,
                    cargo,
                    tires);

            cars.add(car);
        }
        String command = scanner.nextLine();

        Predicate<Car> checkType = e1 -> e1.checkType(command);
        Predicate<Car> checkOther = "fragile".equals(command) ?
                Car::checkPressure :
                Car::checkPower;

        cars.stream()
                .filter(checkType)
                .filter(checkOther)
                .forEach(Car::printModel);
    }
}
