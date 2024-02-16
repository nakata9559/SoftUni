package _11_NestedLoops_Lab;

import java.util.Scanner;

public class _04_SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int beginingNum = Integer.parseInt(scanner.nextLine());
        int endNum = Integer.parseInt(scanner.nextLine());
        int wantedNumber = Integer.parseInt(scanner.nextLine());
        int combinations = 0;

        int num1 = beginingNum;
        int num2 = beginingNum;

        while (num1 <= endNum) {
            while (num2 <= endNum) {
                combinations++;

                if (num1 + num2 == wantedNumber) {
                    System.out.printf("Combination N:%d (%d + %d = %d)", combinations, num1, num2, wantedNumber);
                    break;
                }

                num2++;
            }

            if (num1 + num2 == wantedNumber && num2 <= endNum) {
                break;
            }

            num2 = beginingNum;
            num1++;
        }

        if (num1 + num2 != wantedNumber) {
            System.out.printf("%d combinations - neither equals %d", combinations, wantedNumber);
        }
    }
}
