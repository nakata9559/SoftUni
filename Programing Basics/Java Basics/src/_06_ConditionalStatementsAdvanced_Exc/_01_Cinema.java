package _06_ConditionalStatementsAdvanced_Exc;

import java.util.Scanner;

public class _01_Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int collums = Integer.parseInt(scanner.nextLine());

        double pricePremiere = 12;
        double priceNormal = 7.5;
        double priceDiscount = 5;

        switch (type) {
            case "Premiere":
                System.out.printf("%.2f leva", rows * collums * pricePremiere);
                break;
            case "Normal":
                System.out.printf("%.2f leva", rows * collums * priceNormal);
                break;
            case "Discount":
                System.out.printf("%.2f leva", rows * collums * priceDiscount);
                break;
        }
    }
}
