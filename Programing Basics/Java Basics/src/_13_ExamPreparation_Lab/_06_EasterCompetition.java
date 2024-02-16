package _13_ExamPreparation_Lab;

import java.util.Scanner;

public class _06_EasterCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfEasterBreads = Integer.parseInt(scanner.nextLine());

        int highestPoints = Integer.MIN_VALUE;
        String highestPointsCompetitor = "";
        String competitorName = "";
        int competitorPoints = 0;

        for (int i = 0; i < numOfEasterBreads; i++) {

            competitorName = scanner.nextLine();

            String pointsPerReview = scanner.nextLine();

            competitorPoints = 0;

            while (!pointsPerReview.equals("Stop")) {

                competitorPoints += Integer.parseInt(pointsPerReview);

                pointsPerReview = scanner.nextLine();
            }

            System.out.printf("%s has %d points.%n", competitorName, competitorPoints);

            if (competitorPoints > highestPoints) {
                highestPoints = competitorPoints;
                highestPointsCompetitor = competitorName;
                System.out.printf("%s is the new number 1!%n", competitorName);
            }

        }
        System.out.printf("%s won competition with %d points!%n", highestPointsCompetitor, highestPoints);
    }
}
