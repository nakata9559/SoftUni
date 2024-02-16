package _02_BasicSyntax_ConditionalStatements_And_Loops_Exc;

import java.util.Scanner;

public class _03_Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        String typeOfPeople = scanner.nextLine();
        String dayOfTheWeek = scanner.nextLine();
        double price = 0;

        switch (typeOfPeople) {
            case "Students":
                switch (dayOfTheWeek) {
                    case "Friday":
                        price = 8.45;
                        break;
                    case "Saturday":
                        price = 9.8;
                        break;
                    case "Sunday":
                        price = 10.46;
                        break;
                }
                if (numberOfPeople >= 30) {
                    price *= 0.85;
                }
                break;
            case "Business":
                switch (dayOfTheWeek) {
                    case "Friday":
                        price = 10.9;
                        break;
                    case "Saturday":
                        price = 15.6;
                        break;
                    case "Sunday":
                        price = 16;
                        break;
                }
                if (numberOfPeople >= 100) {
                    numberOfPeople -= 10;
                }
                break;
            case "Regular":
                switch (dayOfTheWeek) {
                    case "Friday":
                        price = 15;
                        break;
                    case "Saturday":
                        price = 20;
                        break;
                    case "Sunday":
                        price = 22.5;
                        break;
                }
                if (numberOfPeople >= 10 && numberOfPeople <= 20) {
                    price *= 0.95;
                }
                break;
        }

        double totalPrice = price * numberOfPeople;

        System.out.printf("Total price: %.2f", totalPrice);
    }
}
