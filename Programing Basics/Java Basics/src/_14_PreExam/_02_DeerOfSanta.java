package _14_PreExam;

import java.util.Scanner;

public class _02_DeerOfSanta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysOff = Integer.parseInt(scanner.nextLine());
        int availableFood = Integer.parseInt(scanner.nextLine());
        double foodPerDayFirstReindeer = Double.parseDouble(scanner.nextLine());
        double foodPerDaySecondReindeer = Double.parseDouble(scanner.nextLine());
        double foodPerDayThirdReindeer = Double.parseDouble(scanner.nextLine());

        double requiredFood = daysOff * (foodPerDayFirstReindeer + foodPerDaySecondReindeer + foodPerDayThirdReindeer);

        double diff = availableFood - requiredFood;

        if (requiredFood <= availableFood) {
            System.out.printf("%.0f kilos of food left.", Math.floor(Math.abs(diff)));
        } else {
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(Math.abs(diff)));
        }
    }
}
