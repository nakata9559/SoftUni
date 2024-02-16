package _00_MoreExercises._03_ConditionalStatementsAdvanced_MoreExc;

import java.util.Scanner;

public class _07_SchoolCamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        String groupType = scanner.nextLine();
        int students = Integer.parseInt(scanner.nextLine());
        int stayovers = Integer.parseInt(scanner.nextLine());

        String sport = "";
        double pricePerNight = 0;

        switch (season){
            case "Winter":
                if (groupType.equals("boys")){
                    pricePerNight = 9.6;
                    sport = "Judo";
                } else if (groupType.equals("girls")){
                    pricePerNight = 9.6;
                    sport = "Gymnastics";
                } else if (groupType.equals("mixed")){
                    pricePerNight = 10;
                    sport = "Ski";
                }
                break;

            case "Spring":
                if (groupType.equals("boys")){
                    pricePerNight = 7.2;
                    sport = "Tennis";
                } else if (groupType.equals("girls")){
                    pricePerNight = 7.2;
                    sport = "Athletics";
                } else if (groupType.equals("mixed")){
                    pricePerNight = 9.5;
                    sport = "Cycling";
                }
                break;

            case "Summer":
                if (groupType.equals("boys")){
                    pricePerNight = 15;
                    sport = "Football";
                } else if (groupType.equals("girls")){
                    pricePerNight = 15;
                    sport = "Volleyball";
                } else if (groupType.equals("mixed")){
                    pricePerNight = 20;
                    sport = "Swimming";
                }
                break;
        }

        double priceTotal = pricePerNight * students * stayovers;

        if (students >= 50){
            priceTotal = priceTotal * 0.5;
        } else if (students >= 20){
            priceTotal = priceTotal * 0.85;
        } else if (students >= 10){
            priceTotal = priceTotal * 0.95;
        }

        System.out.printf("%s %.2f lv.", sport, priceTotal);
    }
}
