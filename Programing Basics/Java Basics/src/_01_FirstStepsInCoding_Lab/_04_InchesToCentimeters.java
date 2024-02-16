package _01_FirstStepsInCoding_Lab;

import java.util.Scanner;

public class _04_InchesToCentimeters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double cm = Double.parseDouble(scanner.nextLine());
        double inch = cm * 2.54;
        System.out.println(inch);
    }
}
