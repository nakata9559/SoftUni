package _05_Arrays_Lab;

import java.util.Scanner;

public class _01_DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        String[] day = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };

        if (input >= 1 && input <= 7) {
            System.out.println(day[input - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
