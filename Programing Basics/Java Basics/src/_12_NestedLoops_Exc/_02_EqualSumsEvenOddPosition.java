package _12_NestedLoops_Exc;

import java.util.Scanner;

public class _02_EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());

        for (int i = num1; i <= num2; i++) {

            String currentNum = String.valueOf(i);

            int sumOddPositions = 0;
            int sumEvenPositions = 0;

            for (int j = 0; j < currentNum.length(); j++) {

                int currentDigit = Integer.parseInt(String.valueOf(currentNum.charAt(j)));

                if (j % 2 != 0) {
                    sumOddPositions += currentDigit;

                } else {
                    sumEvenPositions += currentDigit;
                }
            }

            if (sumEvenPositions == sumOddPositions) {
                System.out.print(currentNum + " ");
            }
        }
    }
}
