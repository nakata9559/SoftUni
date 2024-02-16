package _00_MoreExercises._01_FirstStepsInCoding_MoreExc;

import java.util.Scanner;

public class _03_CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double cel = Double.parseDouble(scanner.nextLine());

        double fhr = cel * 1.8 + 32;

        System.out.printf("%.2f", fhr);
    }
}
