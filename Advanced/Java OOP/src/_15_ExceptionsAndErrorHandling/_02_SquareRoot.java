package _15_ExceptionsAndErrorHandling;

import java.util.Scanner;

public class _02_SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int num = Integer.parseInt(scanner.nextLine());

            if (num < 1) {
                throw new NumberFormatException();
            }

            System.out.printf("%.2f%n", Math.sqrt(num));

        } catch (NumberFormatException e) {
            System.out.println("Invalid");

        } finally {
            System.out.println("Goodbye");
        }
    }
}
