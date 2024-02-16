package _04_MultidimensionalArrays_Exc;

import java.util.Arrays;
import java.util.Scanner;

public class _03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] multiArr = new int[size][size];
        for (int row = 0; row < size; row++) {
            multiArr[row] = fillIntArray(scanner);
        }

        int primarySum = 0;
        int secondarySum = 0;

        int row = 0;
        int oppositeRow = size - 1;

        for (int col = 0; col < size; col++) {
            primarySum += multiArr[row++][col];
            secondarySum += multiArr[oppositeRow--][col];
        }

        int diff = Math.abs(primarySum - secondarySum);
        System.out.println(diff);
    }

    public static int[] fillIntArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void printMultiArr(int[][] multiArr) {
        for (int[] eachRow : multiArr) {
            for (int eachNum : eachRow) {
                System.out.printf("%d ", eachNum);
            }
            System.out.println();
        }
    }
}
