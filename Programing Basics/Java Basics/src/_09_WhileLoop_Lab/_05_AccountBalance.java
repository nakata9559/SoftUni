package _09_WhileLoop_Lab;

import java.util.Scanner;

public class _05_AccountBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double total = 0;
        String inputString = scanner.nextLine();

        while (!inputString.equals("NoMoreMoney")) {

            double input = Double.parseDouble(inputString);

            if (input < 0) {
                System.out.println("Invalid operation!");
                break;
            }

            System.out.printf("Increase: %.2f%n", input);
            total += input;
            inputString = scanner.nextLine();
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
