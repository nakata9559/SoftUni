package _01_WorkingWithAbstraction_Lab._04_HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(tokens[0]);
        int numOfDays = Integer.parseInt(tokens[1]);
        String season = tokens[2];
        String discountType = tokens[3];

        System.out.printf("%.2f%n", PriceCalculator.calculatePrice(
                pricePerDay,
                numOfDays,
                season,
                discountType));
    }
}
