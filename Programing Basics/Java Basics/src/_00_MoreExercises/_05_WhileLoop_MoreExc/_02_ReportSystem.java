package _00_MoreExercises._05_WhileLoop_MoreExc;

import java.util.Scanner;

public class _02_ReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int expectedSum = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        int sumCS = 0;
        int sumCC = 0;
        int sumTotal = 0;
        int transactionCount = 0;
        int successfulTransaction = 0;

        while (!command.equals("End")) {

            int sum = Integer.parseInt(command);
            transactionCount++;

            if (transactionCount % 2 != 0) {
                if (sum <= 100) {
                    sumCS += sum;
                    sumTotal += sum;
                    successfulTransaction++;
                    System.out.println("Product sold!");
                } else {
                    System.out.println("Error in transaction!");
                }

            } else {
                if (sum >= 10) {
                    sumCC += sum;
                    sumTotal += sum;
                    successfulTransaction++;
                    System.out.println("Product sold!");
                } else {
                    System.out.println("Error in transaction!");
                }
            }

            if (sumTotal >= expectedSum) {
                break;
            }

            command = scanner.nextLine();

        }

        if (!command.equals("End")) {
            double aveCS = 2.0 * sumCS / successfulTransaction;
            double aveCC = 2.0 * sumCC / successfulTransaction;

            System.out.printf("Average CS: %.2f%nAverage CC: %.2f", aveCS, aveCC);

        } else {
            System.out.println("Failed to collect required money for charity.");
        }
    }
}
