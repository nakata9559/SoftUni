package _05_Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _06_EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayOne = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] arrayTwo = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;
        boolean identical = true;

        for (int index : arrayOne) {

            if (arrayOne[index] == arrayTwo[index]) {
                sum += arrayOne[index];

            } else {
                System.out.printf("Arrays are not identical. Found difference at %d index.", index);
                identical = false;
                break;
            }
        }
        if (identical) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}
