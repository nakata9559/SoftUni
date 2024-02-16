package _00_MoreExercises._03_ConditionalStatementsAdvanced_MoreExc;

import java.util.Scanner;

public class _06_TruckDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        double kilometers = Double.parseDouble(scanner.nextLine());

        double levPerKm = 0;

        if (kilometers <= 5000){
            switch (season){
                case "Spring":
                case "Autumn":
                    levPerKm = 0.75;
                    break;
                case "Summer":
                    levPerKm = 0.9;
                    break;
                case "Winter":
                    levPerKm = 1.05;
                    break;
            }
        } else if (kilometers <= 10000){
            switch (season){
                case "Spring":
                case "Autumn":
                    levPerKm = 0.95;
                    break;
                case "Summer":
                    levPerKm = 1.1;
                    break;
                case "Winter":
                    levPerKm = 1.25;
                    break;
            }
        } else {
            levPerKm = 1.45;
        }

        double netSalary = levPerKm * kilometers * 4 * 0.9;
        System.out.printf("%.2f", netSalary);
    }
}
