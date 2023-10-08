package _06_Arrays_Exc;

import java.util.Arrays;
import java.util.Scanner;

public class _06_EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (numbers.length <= 1) {
            System.out.println(0);
            return;
        }

        boolean areEquals = false;
        int index = 0;

        for (int i = 0; i < numbers.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int j = 0; j < i; j++) {
                leftSum += numbers[j];
            }

            for (int j = numbers.length - 1; j > i; j--) {
                rightSum += numbers[j];
            }

            if (leftSum == rightSum) {
                areEquals = true;
                index = i;
            }
        }
        if (areEquals) {
            System.out.println(index);
        } else {
            System.out.println("no");
        }
    }
}
