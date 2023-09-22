package _04_ConditionalStatements_Exc;

import java.util.Scanner;

public class _07_Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1.	Бюджетът на Петър - реално число в интервала [0.0…100000.0]
        //2.	Броят видеокарти - цяло число в интервала [0…100]
        //3.	Броят процесори - цяло число в интервала [0…100]
        //4.	Броят рам памет - цяло число в интервала [0…100]

        double budget = Double.parseDouble(scanner.nextLine());
        int productN = Integer.parseInt(scanner.nextLine());
        int productM = Integer.parseInt(scanner.nextLine());
        int productP = Integer.parseInt(scanner.nextLine());

        double priceN = 250.00;

        double totalPriceN = priceN * productN;

        double priceM = totalPriceN * 0.35;
        double priceP = totalPriceN * 0.10;

        double sum = productN * priceN + productM * priceM + productP * priceP;

        if (productN > productM) {
            sum = sum * 0.85;
        }

        if (budget >= sum) {
            System.out.printf("You have %.2f leva left!", budget - sum);

        } else {
            System.out.printf("Not enough money! You need %.2f leva more!", sum - budget);
        }

    }
}
