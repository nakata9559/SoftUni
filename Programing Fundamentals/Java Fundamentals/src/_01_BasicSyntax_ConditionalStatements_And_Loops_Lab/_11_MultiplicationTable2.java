package _01_BasicSyntax_ConditionalStatements_And_Loops_Lab;

import java.util.Scanner;

public class _11_MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int multiplier = Integer.parseInt(scanner.nextLine());

        for (int i = multiplier; i <= 10; i++) {
            System.out.println(number + " X " + i + " = " + number * i);
        }

        if (multiplier > 10) {
            System.out.println(number + " X " + multiplier + " = " + number * multiplier);
        }
    }
}
