package _15_Exam;

import java.util.Scanner;

public class _06_GoldMine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfLocations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfLocations; i++) {

            double expectedYieldPerDay = Double.parseDouble(scanner.nextLine());
            int daysDigging = Integer.parseInt(scanner.nextLine());
            double yieldPerDay = 0;

            for (int j = 0; j < daysDigging; j++) {
                yieldPerDay += Double.parseDouble(scanner.nextLine());
            }

            double averageYieldPerDay = yieldPerDay / daysDigging;

            if (averageYieldPerDay >= expectedYieldPerDay) {
                System.out.printf("Good job! Average gold per day: %.2f.%n", averageYieldPerDay);
            } else {
                System.out.printf("You need %.2f gold.%n", expectedYieldPerDay - averageYieldPerDay);
            }

        }
    }
}
