package _14_PreExam;

import java.util.Scanner;

public class _03_ExcursionCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfPeople = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();

        double pricePerPerson = 0;

        if (numOfPeople <= 5) {


            switch (season) {

                case "spring":
                    pricePerPerson = 50;
                    break;

                case "summer":
                    pricePerPerson = 48.50;
                    pricePerPerson *= 0.85;
                    break;

                case "autumn":
                    pricePerPerson = 60;
                    break;

                case "winter":
                    pricePerPerson = 86;
                    pricePerPerson *= 1.08;
                    break;
            }

        } else {

            switch (season) {

                case "spring":
                    pricePerPerson = 48;
                    break;

                case "summer":
                    pricePerPerson = 45;
                    pricePerPerson *= 0.85;
                    break;

                case "autumn":
                    pricePerPerson = 49.5;
                    break;

                case "winter":
                    pricePerPerson = 85;
                    pricePerPerson *= 1.08;
                    break;
            }

        }
        System.out.printf("%.2f leva.", numOfPeople * pricePerPerson);
    }
}
