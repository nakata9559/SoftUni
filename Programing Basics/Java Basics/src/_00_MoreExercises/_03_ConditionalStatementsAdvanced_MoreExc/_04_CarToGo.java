package _00_MoreExercises._03_ConditionalStatementsAdvanced_MoreExc;

import java.util.Scanner;

public class _04_CarToGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String classType = "";
        String carType = "";
        double price = 0;

        if (budget <= 100){
            classType = "Economy class";
            switch (season){
                case "Summer":
                    carType = "Cabrio";
                    price = budget * 0.35;
                    break;
                case "Winter":
                    carType = "Jeep";
                    price = budget * 0.65;
                    break;
            }

        } else if (budget <= 500){
            classType = "Compact class";
            switch (season){
                case "Summer":
                    carType = "Cabrio";
                    price = budget * 0.45;
                    break;
                case "Winter":
                    carType = "Jeep";
                    price = budget * 0.8;
                    break;
            }

        } else {
            classType = "Luxury class";
            carType = "Jeep";
            price = budget * 0.9;
        }

        System.out.printf("%s%n", classType);
        System.out.printf("%s - %.2f", carType, price);
    }
}
