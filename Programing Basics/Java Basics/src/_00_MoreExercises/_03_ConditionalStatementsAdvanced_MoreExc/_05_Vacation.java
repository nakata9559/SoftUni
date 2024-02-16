package _00_MoreExercises._03_ConditionalStatementsAdvanced_MoreExc;

import java.util.Scanner;

public class _05_Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String location = "";
        String type = "";
        double price = 0;

        switch (season){
            case "Summer":
                location = "Alaska";
                break;
            case "Winter":
                location = "Morocco";
                break;
        }

        if (budget <= 1000){
            type = "Camp";
            if (season.equals("Summer")){
                price = budget * 0.65;
            } else if (season.equals("Winter")){
                price = budget * 0.45;
            }

        } else if (budget <= 3000){
            type = "Hut";
            if (season.equals("Summer")){
                price = budget * 0.8;
            } else if (season.equals("Winter")){
                price = budget * 0.6;
            }

        } else {
            type = "Hotel";
            price = budget * 0.9;
        }

        System.out.printf("%s - %s - %.2f", location, type, price);
    }
}
