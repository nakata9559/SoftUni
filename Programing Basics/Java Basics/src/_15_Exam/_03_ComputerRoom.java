package _15_Exam;

import java.util.Scanner;

public class _03_ComputerRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pricePerHour = 0;

        String month = scanner.nextLine();
        int hoursSpent = Integer.parseInt(scanner.nextLine());
        int peopleAmount = Integer.parseInt(scanner.nextLine());
        String dayOrNight = scanner.nextLine();

        switch (dayOrNight) {
            case "day":

                switch (month) {
                    case "march":
                    case "april":
                    case "may":
                        pricePerHour = 10.5;
                        break;

                    case "june":
                    case "july":
                    case "august":
                        pricePerHour = 12.6;
                        break;
                }
            break;

            case "night":

                switch (month) {
                    case "march":
                    case "april":
                    case "may":
                        pricePerHour = 8.4;
                        break;

                    case "june":
                    case "july":
                    case "august":
                        pricePerHour = 10.2;
                        break;
                }
                break;
        }
        if (peopleAmount >= 4) {
            pricePerHour *= 0.9;
        }

        if (hoursSpent >= 5) {
            pricePerHour *= 0.5;
        }
        double totalPrice = pricePerHour * hoursSpent * peopleAmount;

        System.out.printf("Price per person for one hour: %.2f%n", pricePerHour);
        System.out.printf("Total cost of the visit: %.2f%n", totalPrice);
    }
}
