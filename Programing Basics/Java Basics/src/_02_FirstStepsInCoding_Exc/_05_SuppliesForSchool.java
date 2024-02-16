package _02_FirstStepsInCoding_Exc;

import java.util.Scanner;

public class _05_SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pricePens = 5.80;
        double priceMarkers = 7.20;
        double priceDetergent = 1.20;

        int amountPens = Integer.parseInt(scanner.nextLine());
        int amountMarkers = Integer.parseInt(scanner.nextLine());
        int amountDetergent = Integer.parseInt(scanner.nextLine());
        int discount = Integer.parseInt(scanner.nextLine());

        double sum = (pricePens * amountPens + priceMarkers * amountMarkers + priceDetergent * amountDetergent) * (1 - (double) discount / 100);

        System.out.println(sum);
    }
}
