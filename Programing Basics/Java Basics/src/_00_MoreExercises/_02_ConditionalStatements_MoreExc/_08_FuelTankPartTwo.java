package _00_MoreExercises._02_ConditionalStatements_MoreExc;

import java.util.Scanner;

public class _08_FuelTankPartTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Типа на горивото – текст с възможности: "Gas", "Gasoline" или "Diesel"
        //•	Количество гориво – реално число в интервала [1.00 … 50.00]
        //•	Притежание на клубна карта – текст с възможности: "Yes" или "No"

        String fuelType = scanner.nextLine();
        double fuelAmount = Double.parseDouble(scanner.nextLine());
        String card = scanner.nextLine();

        double priceGasoline = 2.22;
        double priceDiesel = 2.33;
        double priceGas = 0.93;

        if (card.equals("Yes")) {
            priceGasoline = priceGasoline - 0.18;
            priceDiesel = priceDiesel - 0.12;
            priceGas = priceGas - 0.08;
        }

        if (fuelType.equals("Gasoline")) {
            double sumTotal = priceGasoline * fuelAmount;
            if (fuelAmount > 25) {
                sumTotal = sumTotal * 0.9;
                System.out.printf("%.2f lv.", sumTotal);
            } else if (fuelAmount >= 20) {
                sumTotal = sumTotal * 0.92;
                System.out.printf("%.2f lv.", sumTotal);
            } else {
                System.out.printf("%.2f lv.", sumTotal);
            }
        }

        if (fuelType.equals("Diesel")) {
            double sumTotal = priceDiesel * fuelAmount;
            if (fuelAmount > 25) {
                sumTotal = sumTotal * 0.9;
                System.out.printf("%.2f lv.", sumTotal);
            } else if (fuelAmount >= 20) {
                sumTotal = sumTotal * 0.92;
                System.out.printf("%.2f lv.", sumTotal);
            } else {
                System.out.printf("%.2f lv.", sumTotal);
            }
        }

        if (fuelType.equals("Gas")) {
            double sumTotal = priceGas * fuelAmount;
            if (fuelAmount > 25) {
                sumTotal = sumTotal * 0.9;
                System.out.printf("%.2f lv.", sumTotal);
            } else if (fuelAmount >= 20) {
                sumTotal = sumTotal * 0.92;
                System.out.printf("%.2f lv.", sumTotal);
            } else {
                System.out.printf("%.2f lv.", sumTotal);
            }
        }


    }
}
