package _02_BasicSyntax_ConditionalStatements_And_Loops_Exc;

import java.util.Scanner;

public class _02_Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        int highestDivisible = 0;

        if (input % 10 == 0) {
            highestDivisible = 10;
        } else if (input % 7 == 0) {
            highestDivisible = 7;
        } else if (input % 6 == 0) {
            highestDivisible = 6;
        } else if (input % 3 == 0) {
            highestDivisible = 3;
        } else if (input % 2 == 0) {
            highestDivisible = 2;
        }

        if (highestDivisible != 0) {
            System.out.println("The number is divisible by " + highestDivisible);
        } else {
            System.out.println("Not divisible");
        }
    }
}
