package _04_MultidimensionalArrays_Exc;

import java.util.Arrays;
import java.util.Scanner;

public class _04_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim = fillIntArray(scanner);
        int rows = dim[0];
        int cols = dim[1];

        int[][] multiArr = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            multiArr[row] = fillIntArray(scanner);
        }

        int maxSum = Integer.MIN_VALUE;
        int[][] maxSumMultiArr = new int[3][3];

        for (int row = 1; row < rows - 1; row++) {
            for (int col = 1; col < cols - 1; col++) {
                int num00 = multiArr[row - 1][col - 1];
                int num01 = multiArr[row - 1][col];
                int num02 = multiArr[row - 1][col + 1];
                int num10 = multiArr[row][col - 1];
                int num11 = multiArr[row][col];
                int num12 = multiArr[row][col + 1];
                int num20 = multiArr[row + 1][col - 1];
                int num21 = multiArr[row + 1][col];
                int num22 = multiArr[row + 1][col + 1];
                int currentSum = num00 + num01 + num02 + num10 + num11 + num12 + num20 + num21 + num22;

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxSumMultiArr = new int[][]{
                            {num00, num01, num02},
                            {num10, num11, num12},
                            {num20, num21, num22}
                    };
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        printMultiArr(maxSumMultiArr);
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