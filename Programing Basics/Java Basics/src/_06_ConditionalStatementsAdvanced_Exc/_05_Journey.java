package _06_ConditionalStatementsAdvanced_Exc;

import java.util.Scanner;

public class _05_Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String vacationType = "";
        String destination = "";
        double spendMoney = 0;

        if (season.equals("summer")) {
            vacationType = "Camp";
            if (budget <= 100) {
                destination = "Bulgaria";
                spendMoney = budget * 0.3;
            } else if (budget <= 1000) {
                destination = "Balkans";
                spendMoney = budget * 0.4;
            } else {
                destination = "Europe";
                vacationType = "Hotel";
                spendMoney = budget * 0.9;
            }

        } else if (season.equals("winter")) {
            vacationType = "Hotel";
            if (budget <= 100) {
                destination = "Bulgaria";
                spendMoney = budget * 0.7;
            } else if (budget <= 1000) {
                destination = "Balkans";
                spendMoney = budget * 0.8;
            } else {
                destination = "Europe";
                spendMoney = budget * 0.9;
            }
        }
        System.out.printf("Somewhere in %s%n%s - %.2f", destination, vacationType, spendMoney);
    }
}
