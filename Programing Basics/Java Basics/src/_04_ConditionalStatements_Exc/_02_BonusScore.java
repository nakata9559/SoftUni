package _04_ConditionalStatements_Exc;

import java.util.Scanner;

public class _02_BonusScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int points = Integer.parseInt(scanner.nextLine());

        //•	Ако числото е до 100 включително, бонус точките са 5.
        //•	Ако числото е по-голямо от 100, бонус точките са 20% от числото.
        //•	Ако числото е по-голямо от 1000, бонус точките са 10% от числото.

        double bonus = 0.0;

        if (points <= 100) {
            bonus = 5;

        } else if (points <= 1000) {
            bonus = points * 0.2;

        } else {
            bonus = points * 0.1;
        }

        //•	Допълнителни бонус точки (начисляват се отделно от предходните):
        //o	За четно число  + 1 т.
        //o	За число, което завършва на 5  + 2 т.

        if (points % 2 == 0) {
            bonus = bonus + 1;

        } else if (points % 10 == 5) {
            bonus = bonus + 2;
        }

        double score = points + bonus;
        System.out.printf("%.1f%n%.1f",bonus, score);
    }
}
