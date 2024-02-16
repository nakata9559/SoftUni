package _13_ExamPreparation_Lab;

import java.util.Scanner;

public class _02_Skeleton {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int controlMinutes = Integer.parseInt(scanner.nextLine());
        int controlSeconds = Integer.parseInt(scanner.nextLine());
        double chuteLength = Double.parseDouble(scanner.nextLine());
        int secondsPerHundredMeters = Integer.parseInt(scanner.nextLine());

        controlSeconds += controlMinutes * 60;

        double contestantSeconds = 1.0 * secondsPerHundredMeters / 100 * chuteLength;

        if (chuteLength >= 120) {
            contestantSeconds -= chuteLength / 120 * 2.5;
        }

        if (contestantSeconds <= controlSeconds) {
            System.out.println("Marin Bangiev won an Olympic quota!");
            System.out.printf("His time is %.3f.", contestantSeconds);
        } else {
            System.out.printf("No, Marin failed! He was %.3f second slower.", contestantSeconds - controlSeconds);
        }
    }
}
