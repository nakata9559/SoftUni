package _00_MoreExercises._04_ForLoop_MoreExc;

import java.util.Scanner;

public class _07_FootballLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());
        int totalFans = Integer.parseInt(scanner.nextLine());

        int fansA = 0;
        int fansB = 0;
        int fansV = 0;
        int fansG = 0;

        for (int i = 0; i < totalFans; i++) {

            String sector = scanner.nextLine();

            switch (sector) {
                case "A":
                    fansA++;
                    break;
                case "B":
                    fansB++;
                    break;
                case "V":
                    fansV++;
                    break;
                case "G":
                    fansG++;
                    break;
            }
        }

        double percentageFansA = 100.0 * fansA / totalFans;
        double percentageFansB = 100.0 * fansB / totalFans;
        double percentageFansV = 100.0 * fansV / totalFans;
        double percentageFansG = 100.0 * fansG / totalFans;
        double percentageCapacity = 100.0 * totalFans / capacity;

        System.out.printf("%.2f%%%n", percentageFansA);
        System.out.printf("%.2f%%%n", percentageFansB);
        System.out.printf("%.2f%%%n", percentageFansV);
        System.out.printf("%.2f%%%n", percentageFansG);
        System.out.printf("%.2f%%%n", percentageCapacity);

    }
}
