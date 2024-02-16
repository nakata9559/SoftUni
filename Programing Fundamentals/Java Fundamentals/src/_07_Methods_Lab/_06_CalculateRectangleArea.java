package _07_Methods_Lab;

import java.util.Scanner;

public class _06_CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        System.out.printf("%.0f", calculateArea(width, height));
    }

    public static double calculateArea(double width, double height) {
        return width * height;
    }
}
