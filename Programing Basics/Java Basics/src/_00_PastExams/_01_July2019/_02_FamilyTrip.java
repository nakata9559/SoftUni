package _00_PastExams._01_July2019;

import java.util.Scanner;

public class _02_FamilyTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int numOfOvernights = Integer.parseInt(scanner.nextLine());
        double overnightPrice = Double.parseDouble(scanner.nextLine());
        int percentExceptionalCosts = Integer.parseInt(scanner.nextLine());

        if (numOfOvernights > 7) {
            overnightPrice *= 0.95;
        }

        double totalCosts = numOfOvernights * overnightPrice + budget * percentExceptionalCosts / 100;

        if (totalCosts <= budget) {
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.", budget - totalCosts);
        } else {
            System.out.printf("%.2f leva needed.", totalCosts - budget);
        }
    }
}
