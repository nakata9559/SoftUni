package _00_PastExams._01_July2019;

import java.util.Scanner;

public class _03a_TravelAgency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String city = scanner.nextLine();
        String bundleType = scanner.nextLine();
        String isVip = scanner.nextLine();
        int daysStaying = Integer.parseInt(scanner.nextLine());

        double pricePerDay = 0;

        if (bundleType.equals("withEquipment") && city.equals("Bansko") || city.equals("Borovets")) {
            pricePerDay = 100;

            if (isVip.equals("yes")){
                pricePerDay *= 0.9;
            }
        }

        if (bundleType.equals("noEquipment") && city.equals("Bansko") || city.equals("Borovets")) {
            pricePerDay = 80;

            if (isVip.equals("yes")){
                pricePerDay *= 0.95;
            }
        }

        if (bundleType.equals("withBreakfast") && city.equals("Varna") || city.equals("Burgas")) {
            pricePerDay = 130;

            if (isVip.equals("yes")){
                pricePerDay *= 0.88;
            }
        }

        if (bundleType.equals("noBreakfast") && city.equals("Varna") || city.equals("Burgas")) {
            pricePerDay = 100;

            if (isVip.equals("yes")){
                pricePerDay *= 0.93;
            }
        }

        if (daysStaying > 7) {
            daysStaying--;
        }

        double sum = daysStaying * pricePerDay;

        if (daysStaying < 1) {
            System.out.println("Days must be positive number!");
        } else if (sum == 0 || !city.equals("Bansko") && !city.equals("Borovets") && !city.equals("Varna") && !city.equals("Burgas") || !bundleType.equals("noEquipment") && !bundleType.equals("withEquipment") && !bundleType.equals("noBreakfast") && !bundleType.equals("withBreakfast")) {
            System.out.println("Invalid input!");
        } else {
            System.out.printf("The price is %.2flv! Have a nice time!", sum);
        }
    }
}
