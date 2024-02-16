package _10_RegularMidExam;

import java.util.Scanner;

public class _01_BurgerBus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfCities = Integer.parseInt(scanner.nextLine());

        double profit = 0;

        for (int i = 1; i <= numOfCities; i++) {
            String cityName = scanner.nextLine();
            double currentEarnings = Double.parseDouble(scanner.nextLine());
            double currentExpenses = Double.parseDouble(scanner.nextLine());

            if (i % 5 == 0) {
                currentEarnings *= 0.9;
            } else if (i % 3 == 0) {
                currentExpenses *= 1.5;
            }

            profit += currentEarnings - currentExpenses;

            System.out.printf("In %s Burger Bus earned %.2f leva.%n", cityName, currentEarnings - currentExpenses);
        }
        System.out.printf("Burger Bus total profit: %.2f leva.", profit);
    }
}
