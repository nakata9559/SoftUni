package _01_WorkingWithAbstraction_Lab._02_PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Rectangle rectangle = new Rectangle(
                new Point(coordinates[0], coordinates[1]),
                new Point(coordinates[2], coordinates[3]));

        int lines = Integer.parseInt(scanner.nextLine());

        while (lines-- > 0) {
            int[] coordinatesCheck = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Point point = new Point(coordinatesCheck[0], coordinatesCheck[1]);

            System.out.println(rectangle.contains(point));
        }
    }
}
