package _00_MoreExercises._01_FirstStepsInCoding_MoreExc;

import java.util.Scanner;

public class _10_WeatherForecast2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double degrees = Double.parseDouble(scanner.nextLine());

        //Градуси	Време
        //26.00 - 35.00	Hot
        //20.1 - 25.9	Warm
        //15.00 - 20.00	Mild
        //12.00 - 14.9	Cool
        //5.00 - 11.9	Cold

        double d11 = 35.0, d12 = 26.0, d21 = 25.9, d22 = 20.1, d31 = 20.0, d32 = 15.0, d41 = 14.9, d42 = 12.0, d51 = 11.9, d52 = 5.0;
 
        if (d11 >= degrees) {
            if (degrees >= d12) {
                System.out.println("Hot");
            }
        }
        if (d21 >= degrees) {
            if (degrees >= d22) {
                System.out.println("Warm");
            }
        }
        if (d31 >= degrees) {
            if (degrees >= d32) {
                System.out.println("Mild");
            }
        }
        if (d41 >= degrees) {
            if (degrees > d42) {
                System.out.println("Cool");
            }
        }
        if (d51 >= degrees) {
            if (degrees >= d52) {
                System.out.println("Cold");
            }
        }
        if (d11 < degrees) {
            System.out.println("unknown");
        }
        if (d52 > degrees) {
            System.out.println("unknown");
        }
    }
}
