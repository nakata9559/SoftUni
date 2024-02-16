package _00_MoreExercises._03_ConditionalStatementsAdvanced_MoreExc;

import java.util.Scanner;

public class _02_BikeRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int juniorContestants = Integer.parseInt(scanner.nextLine());
        int seniorContestants = Integer.parseInt(scanner.nextLine());
        String raceType = scanner.nextLine();

        double juniorFee = 0;
        double seniorFee = 0;

        switch (raceType) {
            case "trail":
                juniorFee = 5.5;
                seniorFee = 7;
                break;

            case "cross-country":
                juniorFee = 8;
                seniorFee = 9.5;
                if (juniorContestants + seniorContestants >= 50) {
                    juniorFee = juniorFee * 0.75;
                    seniorFee = seniorFee * 0.75;
                }
                break;

            case "downhill":
                juniorFee = 12.25;
                seniorFee = 13.75;
                break;

            case "road":
                juniorFee = 20;
                seniorFee = 21.5;
                break;
        }

        double charitySum = (juniorFee * juniorContestants + seniorFee * seniorContestants) * 0.95;
        System.out.printf("%.2f", charitySum);
    }
}
