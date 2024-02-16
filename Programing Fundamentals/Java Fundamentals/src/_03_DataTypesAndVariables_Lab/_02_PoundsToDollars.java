package _03_DataTypesAndVariables_Lab;

import java.util.Scanner;

public class _02_PoundsToDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pounds = Double.parseDouble(scanner.nextLine());

        double exchangeRate = 1.36;

        System.out.printf("%.3f", pounds * exchangeRate);
    }
}
