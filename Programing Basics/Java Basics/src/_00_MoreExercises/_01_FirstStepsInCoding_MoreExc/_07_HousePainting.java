package _00_MoreExercises._01_FirstStepsInCoding_MoreExc;

import java.util.Scanner;

public class _07_HousePainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        double greenPaintPerLitter = 3.4;
        double redPaintPerLitter = 4.3;

        double door = 1.2 * 2;
        double window = 1.5 * 1.5;

        double wallArea = ((x * x * 2) - door) + ((x * y * 2) - 2 * window);
        double roofArea = (x * h) + (x * y * 2);

        double greenPaintExpense = wallArea / greenPaintPerLitter;
        double redPaintExpense = roofArea / redPaintPerLitter;

        System.out.printf("%.2f%n%.2f", greenPaintExpense, redPaintExpense);
    }
}
