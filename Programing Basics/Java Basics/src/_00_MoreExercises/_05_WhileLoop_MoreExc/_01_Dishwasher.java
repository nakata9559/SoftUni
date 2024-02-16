package _00_MoreExercises._05_WhileLoop_MoreExc;

import java.util.Scanner;

public class _01_Dishwasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int millilitersDetergent = Integer.parseInt(scanner.nextLine()) * 750;

        String command = scanner.nextLine();
        int refillCount = 0;
        int platesCount = 0;
        int potsCount = 0;

        while (!command.equals("End")) {

            int dishesPerRefill = Integer.parseInt(command);
            refillCount++;

            if (refillCount % 3 != 0) {
                platesCount += dishesPerRefill;
                millilitersDetergent -= dishesPerRefill * 5;
            } else {
                potsCount += dishesPerRefill;
                millilitersDetergent -= dishesPerRefill * 15;
            }

            if (millilitersDetergent <= 0){
                break;
            }

            command = scanner.nextLine();
        }

        if (millilitersDetergent < 0) {
            System.out.printf("Not enough detergent, %d ml. more necessary!", Math.abs(millilitersDetergent));
        } else {
            System.out.printf("Detergent was enough!%n");
            System.out.printf("%d dishes and %d pots were washed.%n", platesCount, potsCount);
            System.out.printf("Leftover detergent %d ml.", millilitersDetergent);
        }
    }
}
