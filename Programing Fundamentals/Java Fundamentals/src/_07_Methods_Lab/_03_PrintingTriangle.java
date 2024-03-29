package _07_Methods_Lab;

import java.util.Scanner;

public class _03_PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfRows = Integer.parseInt(scanner.nextLine());

        printRow(numOfRows);
    }

    public static void printRow(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d ", j);
            }

            System.out.println();
        }

        for (int i = row - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d ", j);
            }

            System.out.println();
        }
    }
}

