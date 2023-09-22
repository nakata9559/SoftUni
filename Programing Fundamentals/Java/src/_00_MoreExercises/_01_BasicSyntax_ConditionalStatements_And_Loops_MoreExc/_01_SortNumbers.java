package _00_MoreExercises._01_BasicSyntax_ConditionalStatements_And_Loops_MoreExc;

import java.util.Scanner;

public class _01_SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        int middleNum = 0;

        if (num1 <= minNum) {
            minNum = num1;
        }

        if (num2 <= minNum) {
            minNum = num2;
        }

        if (num3 <= minNum) {
            minNum = num3;
        }

        if (num1 >= maxNum) {
            maxNum = num1;
        }

        if (num2 >= maxNum) {
            maxNum = num2;
        }

        if (num3 >= maxNum) {
            maxNum = num3;
        }

        if (num1 == num2 || num1 == num3 || num1 != minNum && num1 != maxNum) {
            middleNum = num1;
        }

        if (num2 == num1 || num2 == num3 || num2 != minNum && num2 != maxNum) {
            middleNum = num2;
        }

        if (num3 == num1 || num3 == num2 || num3 != minNum && num3 != maxNum) {
            middleNum = num3;
        }
        System.out.println(maxNum);
        System.out.println(middleNum);
        System.out.println(minNum);
    }
}
