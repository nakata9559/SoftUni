package _03_MultidimensionalArrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _06_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dim = Integer.parseInt(scanner.nextLine());
        int[][] multiArr = new int[dim][dim];

        for (int row = 0; row < dim; row++) {
            multiArr[row] = fillIntArray(scanner);
        }

        int[][] diagMultiArr = new int[2][dim];

        int colIndex = 0;
        int oppositeIndex = dim - 1;

        for (int row = 0; row < dim; row++) {
            diagMultiArr[0][row] = multiArr[row][colIndex++];
            diagMultiArr[1][dim - 1 - row] = multiArr[row][oppositeIndex--];
        }
        printMultiArr(diagMultiArr);
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
