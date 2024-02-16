package _05_Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _05_EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sumOfEvenNums = 0;
        int sumOfOddNums = 0;

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                sumOfEvenNums += numbers[i];
            } else {
                sumOfOddNums += numbers[i];
            }
        }
        System.out.println(sumOfEvenNums - sumOfOddNums);
    }
}
