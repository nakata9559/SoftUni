package _13_ExamPreparation_Lab;

import java.util.Scanner;

public class _04_Balls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfBalls = Integer.parseInt(scanner.nextLine());

        int totalPoints = 0;
        int numOfRedBalls = 0;
        int numOfOrangeBalls = 0;
        int numOfYellowBalls = 0;
        int numOfWhiteBalls = 0;
        int numOfOtherBalls = 0;
        int dividesFromBlackBalls = 0;

        for (int i = 0; i < numOfBalls; i++) {

            String differentColors = scanner.nextLine();

            if (differentColors.equals("red")) {
                numOfRedBalls++;
                totalPoints += 5;
            } else if (differentColors.equals("orange")) {
                numOfOrangeBalls++;
                totalPoints += 10;
            } else if (differentColors.equals("yellow")) {
                numOfYellowBalls++;
                totalPoints += 15;
            } else if (differentColors.equals("white")) {
                numOfWhiteBalls++;
                totalPoints += 20;
            } else if (differentColors.equals("black")) {
                dividesFromBlackBalls++;
                totalPoints /= 2;
            } else {
                numOfOtherBalls++;
            }
        }

        System.out.printf("Total points: %d%n", totalPoints);
        System.out.printf("Red balls: %d%n", numOfRedBalls);
        System.out.printf("Orange balls: %d%n", numOfOrangeBalls);
        System.out.printf("Yellow balls: %d%n", numOfYellowBalls);
        System.out.printf("White balls: %d%n", numOfWhiteBalls);
        System.out.printf("Other colors picked: %d%n", numOfOtherBalls);
        System.out.printf("Divides from black balls: %d%n", dividesFromBlackBalls);
    }
}
