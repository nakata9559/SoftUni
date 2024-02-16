package _06_ConditionalStatementsAdvanced_Exc;

import java.util.Scanner;

public class _07_HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int overnights = Integer.parseInt(scanner.nextLine());

        double priceStudio = 0;
        double priceApartment = 0;

        switch (month) {
            case "May":
            case "October":
                priceStudio = overnights * 50;
                priceApartment = overnights * 65;
                if (7 < overnights && overnights <= 14) {
                    priceStudio = priceStudio * 0.95;
                } else if (14 < overnights) {
                    priceStudio = priceStudio * 0.7;
                    priceApartment = priceApartment * 0.9;
                }
                break;

            case "June":
            case "September":
                priceStudio = overnights * 75.2;
                priceApartment = overnights * 68.7;
                if (14 < overnights) {
                    priceStudio = priceStudio * 0.8;
                    priceApartment = priceApartment * 0.9;
                }
                break;

            case "July":
            case "August":
                priceStudio = overnights * 76;
                priceApartment = overnights * 77;
                if (14 < overnights) {
                    priceApartment = priceApartment * 0.9;
                }
                break;
        }
        System.out.printf("Apartment: %.2f lv.%nStudio: %.2f lv.", priceApartment, priceStudio);
    }
}
