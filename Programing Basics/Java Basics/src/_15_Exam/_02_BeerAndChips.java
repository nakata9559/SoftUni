package _15_Exam;

import java.util.Scanner;

public class _02_BeerAndChips {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double beerPrice = 1.2;

        String fanName = scanner.nextLine();
        double budget = Double.parseDouble(scanner.nextLine());
        int beerBottlesAmount = Integer.parseInt(scanner.nextLine());
        int chipsAmount = Integer.parseInt(scanner.nextLine());

        double totalBeerPrice = beerPrice * beerBottlesAmount;
        double chipsPrice = totalBeerPrice * 0.45;
        double totalChipsPrice = Math.ceil(chipsPrice * chipsAmount);
        double diff = Math.abs(budget - totalChipsPrice - totalBeerPrice);

        if (budget >= totalBeerPrice + totalChipsPrice) {
        System.out.printf("%s bought a snack and has %.2f leva left.", fanName, diff);

        } else {
            System.out.printf("%s needs %.2f more leva!", fanName, diff);
        }
    }
}
