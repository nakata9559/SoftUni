package _00_MoreExercises._02_ConditionalStatements_MoreExc;

import java.util.Scanner;

public class _07_FuelTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fuelType = scanner.nextLine();
        int amountFuel = Integer.parseInt(scanner.nextLine());

        if (fuelType.equals("Diesel")) {
            if (amountFuel >= 25) {
                System.out.printf("You have enough %s.", fuelType.toLowerCase());
            } else {
                System.out.printf("Fill your tank with %s!", fuelType.toLowerCase());
            }

        } else if (fuelType.equals("Gasoline")) {
            if (amountFuel >= 25) {
                System.out.printf("You have enough %s.", fuelType.toLowerCase());
            } else {
                System.out.printf("Fill your tank with %s!", fuelType.toLowerCase());
            }

        } else if (fuelType.equals("Gas")) {
            if (amountFuel >= 25) {
                System.out.printf("You have enough %s.", fuelType.toLowerCase());
            } else {
                System.out.printf("Fill your tank with %s!", fuelType.toLowerCase());
            }

        } else {
            System.out.println("Invalid fuel!");
        }
    }
}
