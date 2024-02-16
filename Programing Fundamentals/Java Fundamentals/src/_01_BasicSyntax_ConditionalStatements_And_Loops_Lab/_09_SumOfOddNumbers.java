package _01_BasicSyntax_ConditionalStatements_And_Loops_Lab;

import java.util.Scanner;

public class _09_SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 1; i <= n * 2 - 1; i+=2) {
            System.out.println(i);
            sum += i;
        }
        System.out.println("Sum: " + sum);
    }
}
