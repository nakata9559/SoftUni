package _07_ForLoop_Lab;

import java.util.Scanner;

public class _10_OddEvenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sumOddPositions = 0;
        int sumEvenPositions = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            if (i % 2 == 0) {
                sumOddPositions += num;
            } else {
                sumEvenPositions += num;
            }
        }

        if (sumOddPositions == sumEvenPositions) {
            System.out.println("Yes");
            System.out.printf("Sum = %d", sumOddPositions);
        } else {
            System.out.println("No");
            System.out.printf("Diff = %d", Math.abs(sumOddPositions - sumEvenPositions));
        }
    }
}
