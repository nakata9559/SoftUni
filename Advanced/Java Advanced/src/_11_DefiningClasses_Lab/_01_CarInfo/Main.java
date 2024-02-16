package _11_DefiningClasses_Lab._01_CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfLines = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        while (numOfLines-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            Car car = new Car();
            car.setBrand(input[0]);
            car.setModel(input[1]);
            car.setHorsepower(input[2]);
            cars.add(car);
        }

        cars.forEach(System.out::println);
    }
}
