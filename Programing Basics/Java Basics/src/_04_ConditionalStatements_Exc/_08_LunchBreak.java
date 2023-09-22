package _04_ConditionalStatements_Exc;

import java.util.Scanner;

public class _08_LunchBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1.	Име на сериал – текст
        //2.	Продължителност на епизод  – цяло число в диапазона [10… 90]
        //3.	Продължителност на почивката  – цяло число в диапазона [10… 120]

        String name = scanner.nextLine();
        int seriesDuration = Integer.parseInt(scanner.nextLine());
        int breakDuration = Integer.parseInt(scanner.nextLine());

        double lunchDuration = breakDuration / 8.0;
        double restDuration = breakDuration / 4.0;

        if (breakDuration >= lunchDuration + restDuration + seriesDuration) {
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.", name, Math.ceil(breakDuration - lunchDuration - restDuration - seriesDuration));

        } else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.", name, Math.ceil(lunchDuration + restDuration + seriesDuration - breakDuration));
        }
    }
}