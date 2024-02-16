package _00_MoreExercises._01_FirstStepsInCoding_MoreExc;

import java.util.Scanner;

public class _08_CircleAreaAndPerimeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double r = Double.parseDouble(scanner.nextLine());

        double area = Math.PI * r * r;
        double perimeter = 2 * Math.PI * r;

        System.out.printf("%.2f%n%.2f", area, perimeter);
    }
}
