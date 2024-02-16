package _00_MoreExercises._02_ConditionalStatements_MoreExc;

import java.util.Scanner;

public class _02_SleepyTomCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysOff = Integer.parseInt(scanner.nextLine());

        double tomPlayMinutesPerYear = 30000;

        //•	Когато е на работа, стопанинът му си играе с него по 63 минути на ден.
        //•	Когато почива, стопанинът му си играе с него  по 127 минути на ден.

        double minutesPlayedWithTomTotal = (365 - daysOff) * 63 + daysOff * 127;
        double minutesPlayedWithTom = (tomPlayMinutesPerYear - minutesPlayedWithTomTotal) / 60 % 1 * 60;
        double hoursPlayedWithTom = Math.floor((tomPlayMinutesPerYear - minutesPlayedWithTomTotal) / 60);

        //•	Ако времето за игра на Том е над нормата за текущата година:
        //o	 На първия ред отпечатайте: “Tom will run away”
        //o	 На втория ред отпечатайте разликата от нормата във формат:
        //“{H} hours and {M} minutes more for play”
        //•	Ако времето за игра на Том е под нормата за текущата година:
        //o	На първия ред отпечатайте: “Tom sleeps well”
        //o	 На втория ред отпечатайте разликата от нормата във формат:
        //“{H} hours and {M} minutes less for play”

        if (tomPlayMinutesPerYear < minutesPlayedWithTomTotal) {
            minutesPlayedWithTom = (minutesPlayedWithTomTotal - tomPlayMinutesPerYear) / 60 % 1 * 60;
            hoursPlayedWithTom = Math.floor((minutesPlayedWithTomTotal - tomPlayMinutesPerYear) / 60);
            System.out.printf("Tom will run away%n%.0f hours and %.0f minutes more for play", hoursPlayedWithTom, minutesPlayedWithTom);
        } else {
            System.out.printf("Tom sleeps well%n%.0f hours and %.0f minutes less for play", hoursPlayedWithTom, minutesPlayedWithTom);
        }
    }
}
