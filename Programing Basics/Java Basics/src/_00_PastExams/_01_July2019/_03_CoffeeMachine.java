package _00_PastExams._01_July2019;

import java.util.Scanner;

public class _03_CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String drinkType = scanner.nextLine();
        String sugar = scanner.nextLine();
        int numOfDrinks = Integer.parseInt(scanner.nextLine());

        double price = 0;

        switch (drinkType) {

            case "Espresso":

                switch (sugar) {

                    case "Without":
                        price = 0.90;
                        break;

                    case "Normal":
                        price = 1.00;
                        break;

                    case "Extra":
                        price = 1.20;
                        break;
                }
                break;

            case "Cappuccino":

                switch (sugar) {

                    case "Without":
                        price = 1.00;
                        break;

                    case "Normal":
                        price = 1.20;
                        break;

                    case "Extra":
                        price = 1.60;
                        break;
                }
                break;

            case "Tea":

                switch (sugar) {

                    case "Without":
                        price = 0.50;
                        break;

                    case "Normal":
                        price = 0.60;
                        break;

                    case "Extra":
                        price = 0.70;
                        break;
                }
            break;
        }


        if (sugar.equals("Without")) {
            price *= 0.65;
        }

        if (drinkType.equals("Espresso") && numOfDrinks >= 5) {
            price *= 0.75;
        }

        double sum = price * numOfDrinks;

        if (sum > 15) {
            sum *= 0.8;
        }

        System.out.printf("You bought %d cups of %s for %.2f lv.", numOfDrinks, drinkType, sum);
    }
}
