package _02_BasicSyntax_ConditionalStatements_And_Loops_Exc;

import java.util.Scanner;

public class _07_VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double nutsPrice = 2;
        double waterPrice = 0.7;
        double crispsPrice = 1.5;
        double sodaPrice = 0.8;
        double cokePrice = 1;

        double totalMoney = 0;

        String input = scanner.nextLine();

        while (!input.equals("Start")) {
            double inputDouble = Double.parseDouble(input);

            if (inputDouble == 0.1 || inputDouble == 0.2 || inputDouble == 0.5 || inputDouble == 1 || inputDouble == 2) {
                totalMoney += inputDouble;
            } else {
                System.out.printf("Cannot accept %.2f%n", inputDouble);
            }

            input = scanner.nextLine();
        }

        while (!input.equals("End")) {
            switch (input) {
                case "Nuts":
                    if (totalMoney >= nutsPrice) {
                        totalMoney -= nutsPrice;
                        System.out.printf("Purchased %s%n", input);
                    } else {
                        System.out.printf("Sorry, not enough money%n");
                    }
                    break;
                case  "Water":
                    if (totalMoney >= waterPrice) {
                        totalMoney -= waterPrice;
                        System.out.printf("Purchased %s%n", input);
                    } else {
                        System.out.printf("Sorry, not enough money%n");
                    }
                    break;
                case "Crisps":
                    if (totalMoney >= crispsPrice) {
                        totalMoney -= crispsPrice;
                        System.out.printf("Purchased %s%n", input);
                    } else {
                        System.out.printf("Sorry, not enough money%n");
                    }
                    break;
                case "Soda":
                    if (totalMoney >= sodaPrice) {
                        totalMoney -= sodaPrice;
                        System.out.printf("Purchased %s%n", input);
                    } else {
                        System.out.printf("Sorry, not enough money%n");
                    }
                    break;
                case "Coke":
                    if (totalMoney >= cokePrice) {
                        totalMoney -= cokePrice;
                        System.out.printf("Purchased %s%n", input);
                    } else {
                        System.out.printf("Sorry, not enough money%n");
                    }
                    break;
                case "Start":
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }


            input = scanner.nextLine();
        }

        System.out.printf("Change: %.2f", totalMoney);
    }
}
