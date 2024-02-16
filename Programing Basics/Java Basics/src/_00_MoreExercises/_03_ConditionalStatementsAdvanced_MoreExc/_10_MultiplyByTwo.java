package _00_MoreExercises._03_ConditionalStatementsAdvanced_MoreExc;

import java.util.Scanner;

public class _10_MultiplyByTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num = Double.parseDouble(scanner.nextLine());

        while (num >= 0){
            num = num * 2;
            System.out.printf("Result: %.2f%n", num);
            num = Double.parseDouble(scanner.nextLine());
        }

        System.out.println("Negative number!");
    }
}
