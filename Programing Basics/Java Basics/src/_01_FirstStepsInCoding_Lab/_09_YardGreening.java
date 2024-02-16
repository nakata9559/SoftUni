package _01_FirstStepsInCoding_Lab;

import java.util.Scanner;

public class _09_YardGreening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double area = Double.parseDouble(scanner.nextLine());
        double ppm2 = 7.61;
        double discount = area * ppm2 * 0.18;
        double finalPrice = area * ppm2 - discount;
        System.out.println("The final price is: " + finalPrice + " lv.");
        System.out.println("The discount is: " + discount + " lv.");
    }
}
