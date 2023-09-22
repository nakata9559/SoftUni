package _06_ConditionalStatementsAdvanced_Exc;

import java.util.Scanner;

public class _03_NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String flowersType = scanner.nextLine();
        int flowersQuantity = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double priceRose = 5;
        double priceDahlia = 3.8;
        double priceTulip = 2.8;
        double priceNarcissus = 3;
        double priceGladiolus = 2.5;

        double sum = 0;

        if (flowersType.equals("Roses")) {
            if (flowersQuantity > 80) {
                sum = flowersQuantity * priceRose * 0.9;
                if (budget >= sum) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowersQuantity, flowersType, budget - sum);
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.", sum - budget);
                }

            } else {
                sum = flowersQuantity * priceRose;
                if (budget >= sum) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowersQuantity, flowersType, budget - sum);
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.", sum - budget);
                }
            }



        } else if (flowersType.equals("Dahlias")) {
            if (flowersQuantity > 90) {
                sum = flowersQuantity * priceDahlia * 0.85;
                if (budget >= sum) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowersQuantity, flowersType, budget - sum);
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.", sum - budget);
                }

            } else {
                sum = flowersQuantity * priceDahlia;
                if (budget >= sum) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowersQuantity, flowersType, budget - sum);
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.", sum - budget);
                }
            }



        } else if (flowersType.equals("Tulips")) {
            if (flowersQuantity > 80) {
                sum = flowersQuantity * priceTulip * 0.85;
                if (budget >= sum) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowersQuantity, flowersType, budget - sum);
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.", sum - budget);
                }

            } else {
                sum = flowersQuantity * priceTulip;
                if (budget >= sum) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowersQuantity, flowersType, budget - sum);
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.", sum - budget);
                }
            }


        } else if (flowersType.equals("Narcissus")) {
            if (flowersQuantity < 120) {
                sum = flowersQuantity * priceNarcissus * 1.15;
                if (budget >= sum) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowersQuantity, flowersType, budget - sum);
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.", sum - budget);
                }

            } else {
                sum = flowersQuantity * priceNarcissus;
                if (budget >= sum) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowersQuantity, flowersType, budget - sum);
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.", sum - budget);
                }
            }


        } else if (flowersType.equals("Gladiolus")) {
            if (flowersQuantity < 80) {
                sum = flowersQuantity * priceGladiolus * 1.2;
                if (budget >= sum) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowersQuantity, flowersType, budget - sum);
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.", sum - budget);
                }

            } else {
                sum = flowersQuantity * priceGladiolus;
                if (budget >= sum) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowersQuantity, flowersType, budget - sum);
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.", sum - budget);
                }
            }
        }
    }
}
