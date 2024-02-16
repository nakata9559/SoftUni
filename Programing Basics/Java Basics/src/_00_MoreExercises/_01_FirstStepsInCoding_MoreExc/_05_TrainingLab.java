package _00_MoreExercises._01_FirstStepsInCoding_MoreExc;

import java.util.Scanner;

public class _05_TrainingLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double w = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        double rowWorkStations = Math.floor((h - 1) / 0.7);
        double columWorkStations = Math.floor(w / 1.2);

        double availableWorkStations = (rowWorkStations * columWorkStations - 3);

        System.out.printf("%.0f", availableWorkStations);

    }
}
