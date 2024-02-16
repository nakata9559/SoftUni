package _05_ConditionalStatementsAdvanced_Lab;

import java.util.Scanner;

public class _11_FruitShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String day = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        double bananaPrice = 2.5;
        double applePrice = 1.2;
        double orangePrice = 0.85;
        double grapefruitPrice = 1.45;
        double kiwiPrice = 2.7;
        double pineapplePrice = 5.5;
        double grapesPrice = 3.85;

        if (day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") || day.equals("Thursday") || day.equals("Friday")) {
            switch (fruit) {
                case "banana":
                    System.out.printf("%.2f", quantity * bananaPrice);
                    break;
                case "apple":
                    System.out.printf("%.2f", quantity * applePrice);
                    break;
                case "orange":
                    System.out.printf("%.2f", quantity * orangePrice);
                    break;
                case "grapefruit":
                    System.out.printf("%.2f", quantity * grapefruitPrice);
                    break;
                case "kiwi":
                    System.out.printf("%.2f", quantity * kiwiPrice);
                    break;
                case "pineapple":
                    System.out.printf("%.2f", quantity * pineapplePrice);
                    break;
                case "grapes":
                    System.out.printf("%.2f", quantity * grapesPrice);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else if (day.equals("Saturday") || day.equals("Sunday")) {
            bananaPrice = 2.7;
            applePrice = 1.25;
            orangePrice = 0.9;
            grapefruitPrice = 1.6;
            kiwiPrice = 3;
            pineapplePrice = 5.6;
            grapesPrice = 4.2;

            switch (fruit) {
                case "banana":
                    System.out.printf("%.2f", quantity * bananaPrice);
                    break;
                case "apple":
                    System.out.printf("%.2f", quantity * applePrice);
                    break;
                case "orange":
                    System.out.printf("%.2f", quantity * orangePrice);
                    break;
                case "grapefruit":
                    System.out.printf("%.2f", quantity * grapefruitPrice);
                    break;
                case "kiwi":
                    System.out.printf("%.2f", quantity * kiwiPrice);
                    break;
                case "pineapple":
                    System.out.printf("%.2f", quantity * pineapplePrice);
                    break;
                case "grapes":
                    System.out.printf("%.2f", quantity * grapesPrice);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else {
            System.out.println("error");
        }
    }
}
