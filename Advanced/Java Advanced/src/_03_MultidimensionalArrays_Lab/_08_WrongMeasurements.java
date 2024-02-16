package _03_MultidimensionalArrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _08_WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] multiArr = new int[rows][];

        for (int row = 0; row < rows; row++) {
            multiArr[row] = fillIntArray(scanner);
        }

        int[][] replacedMultiArr = new int[rows][multiArr[0].length];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < multiArr[row].length; col++) {
                replacedMultiArr[row][col] = multiArr[row][col];
            }
        }

        int[] mistakenIndex = fillIntArray(scanner);
        int mistakenValue = multiArr[mistakenIndex[0]][mistakenIndex[1]];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < multiArr[row].length; col++) {
                int num = multiArr[row][col];

                if (num == mistakenValue) {
                    int sum = 0;
                    if (row - 1 != -1) {
                        int currentNum = multiArr[row - 1][col];
                        if (currentNum != mistakenValue) {
                            sum += currentNum;
                        }
                    }

                    if (col - 1 != -1) {
                        int currentNum = multiArr[row][col - 1];
                        if (currentNum != mistakenValue) {
                            sum += currentNum;
                        }
                    }

                    if (row + 1 != rows) {
                        int currentNum = multiArr[row + 1][col];
                        if (currentNum != mistakenValue) {
                            sum += currentNum;
                        }
                    }

                    if (col + 1 != multiArr[row].length) {
                        int currentNum = multiArr[row][col + 1];
                        if (currentNum != mistakenValue) {
                            sum += currentNum;
                        }
                    }
                    replacedMultiArr[row][col] = sum;
                }
            }
        }
        printMultiArr(replacedMultiArr);
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
