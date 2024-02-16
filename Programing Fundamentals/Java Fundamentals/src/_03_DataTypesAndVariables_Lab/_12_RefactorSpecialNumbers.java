package _03_DataTypesAndVariables_Lab;

import java.util.Scanner;

public class _12_RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= num; i++) {
            int sum = 0;
            int currentDigit = i;

            while (currentDigit > 0) {
                sum += currentDigit % 10;
                currentDigit = currentDigit / 10;
            }

            boolean isSpecialNum = (sum == 5) || (sum == 7) || (sum == 11);
            if (isSpecialNum) {
                System.out.printf("%d -> True%n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }
        }
    }
}
