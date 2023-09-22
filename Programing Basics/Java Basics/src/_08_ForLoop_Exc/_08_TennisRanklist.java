package _08_ForLoop_Exc;

import java.util.Scanner;

public class _08_TennisRanklist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tournaments = Integer.parseInt(scanner.nextLine());
        int startPoints = Integer.parseInt(scanner.nextLine());

        int tournamentPoints = 0;
        int wins = 0;

        for (int i = 0; i < tournaments; i++) {
            String stage = scanner.nextLine();

            switch (stage) {
                case "W":
                    tournamentPoints += 2000;
                    wins++;
                    break;
                case "F":
                    tournamentPoints += 1200;
                    break;
                case "SF":
                    tournamentPoints += 720;
                    break;
            }
        }
        System.out.println("Final points: " + (startPoints + tournamentPoints));
        System.out.println("Average points: " + (tournamentPoints / tournaments));
        System.out.printf("%.2f%%", 100.0 * wins / tournaments);
    }
}
