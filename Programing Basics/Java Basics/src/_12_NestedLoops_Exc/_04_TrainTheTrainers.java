package _12_NestedLoops_Exc;

import java.util.Scanner;

public class _04_TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int referees = Integer.parseInt(scanner.nextLine());

        int presentations = 0;
        double sumAverages = 0;

        String command = scanner.nextLine();

        while (!command.equals("Finish")) {

            presentations++;
            String presentation = command;
            double review = 0;

            for (int numOfReviews = 1; numOfReviews <= referees; numOfReviews++) {

                review += Double.parseDouble(scanner.nextLine());

            }

            double averagePerPresentation = review / referees;
            sumAverages += averagePerPresentation;
            System.out.printf("%s - %.2f.%n", presentation, averagePerPresentation);
            command = scanner.nextLine();
        }

        double averageTotal = sumAverages / presentations;
        System.out.printf("Student's final assessment is %.2f.", averageTotal);
    }
}
