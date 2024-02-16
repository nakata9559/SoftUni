package _00_MoreExercises._04_ForLoop_MoreExc;

import java.util.Scanner;

public class _01_BackToThePast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double herritage = Double.parseDouble(scanner.nextLine());
        int yearToLive = Integer.parseInt(scanner.nextLine());

        int currentAge = 18;
        double expenses = 0;

        for (int i = 1800; i <= yearToLive; i++) {

            if (i % 2 == 0) {
                expenses += 12000;
            } else {
                expenses += 12000 + 50 * currentAge;
            }
            currentAge++;
        }
        if (herritage >= expenses) {
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", herritage - expenses);
        } else {
            System.out.printf("He will need %.2f dollars to survive.", expenses - herritage);
        }
    }
}
