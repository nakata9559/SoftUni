package _07_Methods_Lab;

import java.util.Scanner;

public class _10_MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        System.out.println(sumOfEvenDigits(Math.abs(number)) * sumOfOddDigits(Math.abs(number)));
    }

    public static int sumOfEvenDigits(int n) {
        int sum = 0;

        for (int i = n; i > 0; i /= 10) {
            if (i % 2 == 0) {
                sum += i % 10;
            }
        }


        return sum;
    }

    public static int sumOfOddDigits(int n) {
        int sum = 0;

        for (int i = n; i > 0; i /= 10) {
            if (i % 2 != 0) {
                sum += i % 10;
            }
        }


        return sum;
    }
}
