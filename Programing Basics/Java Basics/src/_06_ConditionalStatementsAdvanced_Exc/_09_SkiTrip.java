package _06_ConditionalStatementsAdvanced_Exc;

import java.util.Scanner;

public class _09_SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        String room = scanner.nextLine();
        String review = scanner.nextLine();

        int nights = days - 1;
        double sum = 0;
        double priceRoomForOnePerson = 18;
        double priceApartment = 25;
        double pricePresidentApartment = 35;

        switch (room) {
            case "room for one person":
                sum = priceRoomForOnePerson * nights;
                break;

            case "apartment":
                sum = priceApartment * nights;
                if (days < 10) {
                    sum = sum * 0.7;
                } else if (days <= 15) {
                    sum = sum * 0.65;
                } else {
                    sum = sum * 0.5;
                }
                break;

            case "president apartment":
                sum = pricePresidentApartment * nights;
                if (days < 10) {
                    sum = sum * 0.9;
                } else if (days <= 15) {
                    sum = sum * 0.85;
                } else {
                    sum = sum * 0.8;
                }
                break;
            }

        if (review.equals("negative")) {
            sum = sum * 0.9;
        }
        if (review.equals("positive")) {
            sum = sum * 1.25;
        }
        System.out.printf("%.2f", sum);
    }
}
