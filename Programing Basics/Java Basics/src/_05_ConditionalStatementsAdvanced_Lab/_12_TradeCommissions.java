package _05_ConditionalStatementsAdvanced_Lab;

import java.util.Scanner;

public class _12_TradeCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String city = scanner.nextLine();
        double salesAmount = Double.parseDouble(scanner.nextLine());

        double commision = 0;

        if (0 <= salesAmount && salesAmount <= 500) {
            switch (city) {
                case "Sofia":
                    commision = 0.05;
                    System.out.printf("%.2f", salesAmount * commision);
                    break;
                case "Varna":
                    commision = 0.045;
                    System.out.printf("%.2f", salesAmount * commision);
                    break;
                case "Plovdiv":
                    commision = 0.055;
                    System.out.printf("%.2f", salesAmount * commision);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else if (500 < salesAmount && salesAmount <= 1000) {
            switch (city) {
                case "Sofia":
                    commision = 0.07;
                    System.out.printf("%.2f", salesAmount * commision);
                    break;
                case "Varna":
                    commision = 0.075;
                    System.out.printf("%.2f", salesAmount * commision);
                    break;
                case "Plovdiv":
                    commision = 0.08;
                    System.out.printf("%.2f", salesAmount * commision);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else if (1000 < salesAmount && salesAmount <= 10000) {
            switch (city) {
                case "Sofia":
                    commision = 0.08;
                    System.out.printf("%.2f", salesAmount * commision);
                    break;
                case "Varna":
                    commision = 0.1;
                    System.out.printf("%.2f", salesAmount * commision);
                    break;
                case "Plovdiv":
                    commision = 0.12;
                    System.out.printf("%.2f", salesAmount * commision);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else if (10000 < salesAmount) {
            switch (city) {
                case "Sofia":
                    commision = 0.12;
                    System.out.printf("%.2f", salesAmount * commision);
                    break;
                case "Varna":
                    commision = 0.13;
                    System.out.printf("%.2f", salesAmount * commision);
                    break;
                case "Plovdiv":
                    commision = 0.145;
                    System.out.printf("%.2f", salesAmount * commision);
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
