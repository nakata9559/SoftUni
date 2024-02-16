package _03_MultidimensionalArrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _05_MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim = fillIntArray(scanner);
        int rows = dim[0];
        int cols = dim[1];
        int[][] initialMultiArr = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            initialMultiArr[row] = fillIntArray(scanner);
        }

        int[][] subMultiArr = new int[2][2];
        int sum = Integer.MIN_VALUE;

        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int num1 = initialMultiArr[row][col];
                int num2 = initialMultiArr[row][col + 1];
                int num3 = initialMultiArr[row + 1][col];
                int num4 = initialMultiArr[row + 1][col + 1];
                int currentSum = num1 + num2 + num3 + num4;

                if (sum < currentSum) {
                    sum = currentSum;
                    subMultiArr = new int[][]{
                            {num1, num2},
                            {num3, num4}
                    };
                }
            }
        }
        printMultiArr(subMultiArr);
        System.out.println(sum);
    }

    public static int[] fillIntArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(",\\s+"))
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
