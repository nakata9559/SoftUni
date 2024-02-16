package _00_MoreExercises._02_DataTypesAndVariables_MoreExc;

import java.util.Scanner;

public class _03_FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1 = Double.parseDouble(scanner.nextLine());
        double num2 = Double.parseDouble(scanner.nextLine());

        if (Double.compare(Math.abs(num1 - num2), 0.000001) < 0) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
