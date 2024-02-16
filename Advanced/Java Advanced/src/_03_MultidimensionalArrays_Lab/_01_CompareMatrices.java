package _03_MultidimensionalArrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _01_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim1 = fillArray(scanner);
        int rows1 = dim1[0];
        int cols1 = dim1[1];
        int[][] multiArray1 = new int[rows1][cols1];

        for (int row = 0; row < rows1; row++) {
            multiArray1[row] = fillArray(scanner);
        }

        int[] dim2 = fillArray(scanner);
        int rows2 = dim2[0];
        int cols2 = dim2[1];
        int[][] multiArray2 = new int[rows2][cols2];

        for (int row = 0; row < rows2; row++) {
            multiArray2[row] = fillArray(scanner);
        }

        if (rows1 == rows2 && cols1 == cols2) {
            for (int row = 0; row < rows1; row++) {
                for (int col = 0; col < cols1; col++) {
                    if (multiArray1[row][col] != multiArray2[row][col]) {
                        System.out.println("not equal");
                        return;
                    }
                }
            }
        } else {
            System.out.println("not equal");
            return;
        }
        System.out.println("equal");
    }

    public static int[] fillArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
