package _07_Methods_Lab;

import java.util.Scanner;

public class _05_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        calculatePrice(product, quantity);
    }

    public static void calculatePrice(String product, double quantity) {
        switch (product) {
            case "coffee":
                System.out.printf("%.2f%n", quantity * 1.5);
                break;
            case "water":
                System.out.printf("%.2f%n", quantity * 1);
                break;
            case "coke":
                System.out.printf("%.2f%n", quantity * 1.4);
                break;
            case "snacks":
                System.out.printf("%.2f%n", quantity * 2);
                break;
        }
    }
}
