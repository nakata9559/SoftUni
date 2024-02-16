package _13_ExamPreparation_Lab;

import java.util.Scanner;

public class _01_SeriesCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String seriesName = scanner.nextLine();
        int numOfSeasons = Integer.parseInt(scanner.nextLine());
        int numOfEpisodes = Integer.parseInt(scanner.nextLine());
        double episodeLength = Double.parseDouble(scanner.nextLine());

        double totalMinutes = numOfSeasons * numOfEpisodes * episodeLength * 1.2 + numOfSeasons * 10;

        System.out.printf("Total time needed to watch the %s series is %.0f minutes.", seriesName, Math.floor(totalMinutes));
    }
}
