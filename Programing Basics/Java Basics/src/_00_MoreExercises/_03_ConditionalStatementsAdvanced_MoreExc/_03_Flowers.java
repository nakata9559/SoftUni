package _00_MoreExercises._03_ConditionalStatementsAdvanced_MoreExc;

import java.util.Scanner;

public class _03_Flowers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chrysanthemumsAmount = Integer.parseInt(scanner.nextLine());
        int rosesAmount = Integer.parseInt(scanner.nextLine());
        int tulipsAmount = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String hollyday = scanner.nextLine();

        double chrysanthemumPrice = 0;
        double rosesPrice = 0;
        double tulipsPrice = 0;

        switch (season){
            case "Spring":
            case "Summer":
                chrysanthemumPrice = 2;
                rosesPrice = 4.1;
                tulipsPrice = 2.5;
                break;

            case "Autumn":
            case "Winter":
                chrysanthemumPrice = 3.75;
                rosesPrice = 4.5;
                tulipsPrice = 4.15;
                break;
        }

        if (hollyday.equals("Y")){
                chrysanthemumPrice = chrysanthemumPrice * 1.15;
                rosesPrice = rosesPrice * 1.15;
                tulipsPrice = tulipsPrice * 1.15;
        }

        double sum = chrysanthemumPrice * chrysanthemumsAmount + rosesAmount * rosesPrice + tulipsAmount * tulipsPrice;

        if (tulipsAmount > 7 && season.equals("Spring")){
            sum = sum * 0.95;
        }

        if(rosesAmount >= 10 && season.equals("Winter")){
            sum = sum * 0.9;
        }

        if(chrysanthemumsAmount + tulipsAmount + rosesAmount > 20){
            sum = sum * 0.8;
        }

        System.out.printf("%.2f", sum + 2);
    }
}
