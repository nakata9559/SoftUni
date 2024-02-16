package _02_BasicSyntax_ConditionalStatements_And_Loops_Exc;

import java.util.Scanner;

public class _04_PrintAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        int sum = 0;

        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
            sum += i;
        }

        System.out.printf("%nSum: %d", sum);
    }
}