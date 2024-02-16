package _00_MoreExercises._01_FirstStepsInCoding_MoreExc;

import java.util.Scanner;

public class _02_TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        double area = a * h / 2;

        System.out.printf("%.2f", area);
    }
}
