package _11_DefiningClasses_Lab._02_Constructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        while (lines-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            Car car = new Car();

            if (input.length == 1) {
                car = new Car(input[0]);
            } else {
                car = new Car(input[0], input[1], input[2]);
            }

            cars.add(car);
        }

        cars.forEach(System.out::println);
    }
}
