package _00_MoreExercises._04_ForLoop_MoreExc;

import java.util.Scanner;

public class _05_GameOfIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int turns = Integer.parseInt(scanner.nextLine());

        double result = 0;
        int r0To9 = 0;
        int r10To19 = 0;
        int r20To29 = 0;
        int r30To39 = 0;
        int r40To50 = 0;
        int invalid = 0;

        for (int i = 0; i < turns; i++) {

            int pointsPerTurn = Integer.parseInt(scanner.nextLine());

            if (0 <= pointsPerTurn && pointsPerTurn <= 9) {
                result += pointsPerTurn * 0.2;
                r0To9++;

            } else if (10 <= pointsPerTurn && pointsPerTurn <= 19) {
                result += pointsPerTurn * 0.3;
                r10To19++;

            } else if (20 <= pointsPerTurn && pointsPerTurn <= 29) {
                result += pointsPerTurn * 0.4;
                r20To29++;

            } else if (30 <= pointsPerTurn && pointsPerTurn <= 39) {
                result += 50;
                r30To39++;

            } else if (40 <= pointsPerTurn && pointsPerTurn <= 50) {
                result += 100;
                r40To50++;

            } else {
                result /= 2;
                invalid++;
            }
        }

        double percentage0To9 = 100.0 * r0To9 / turns;
        double percentage10To19 = 100.0 * r10To19 / turns;
        double percentage20To29 = 100.0 * r20To29 / turns;
        double percentage30To39 = 100.0 * r30To39 / turns;
        double percentage40To50 = 100.0 * r40To50 / turns;
        double percentageInvalid = 100.0 * invalid / turns;

        System.out.printf("%.2f%n", result);
        System.out.printf("From 0 to 9: %.2f%%%n", percentage0To9);
        System.out.printf("From 10 to 19: %.2f%%%n", percentage10To19);
        System.out.printf("From 20 to 29: %.2f%%%n", percentage20To29);
        System.out.printf("From 30 to 39: %.2f%%%n", percentage30To39);
        System.out.printf("From 40 to 50: %.2f%%%n", percentage40To50);
        System.out.printf("Invalid numbers: %.2f%%%n", percentageInvalid);
    }
}
