package _04_ConditionalStatements_Exc;

import java.util.Scanner;

public class _03_TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputHours = Integer.parseInt(scanner.nextLine());
        int inputMinutes = Integer.parseInt(scanner.nextLine());

        int minutesPlus15 = inputHours * 60 + inputMinutes + 15;

        int hours = minutesPlus15 / 60;
        int minutes = minutesPlus15 % 60;

        if (hours >= 24) {
            hours = hours - 24;
        }

        if (minutes < 10) {
            System.out.printf("%d:0%d", hours, minutes);
        } else {
            System.out.printf("%d:%d", hours, minutes);
        }
    }
}
