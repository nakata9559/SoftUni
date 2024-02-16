package _03_MultidimensionalArrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _04_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim = fillIntArray(scanner);
        int rows = dim[0];
        int cols = dim[1];

        int[][] multiArr = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            multiArr[row] = fillIntArray(scanner);
        }

        int sum = sumMultiArr(multiArr);

        System.out.printf("%d%n%d%n%d%n", rows, cols, sum);
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

    public static int sumMultiArr(int[][] multiArr) {
        int sum = 0;
        for (int[] eachRow : multiArr) for (int eachNum : eachRow) sum += eachNum;
        return sum;
    }
}
