package _03_MultidimensionalArrays_Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] multiArr1 = new char[rows][cols];
        char[][] multiArr2 = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            multiArr1[row] = scanner.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();
        }

        for (int row = 0; row < rows; row++) {
            multiArr2[row] = scanner.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();

        }

        char[][] result = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (multiArr1[row][col] == multiArr2[row][col]) {
                    result[row][col] = multiArr1[row][col];
                } else {
                    result[row][col] = '*';
                }
            }
        }

        printMultiArr(result);
    }

    public static void printMultiArr(char[][] multiArr) {
        for (char[] eachRow : multiArr) {
            for (char eachChar : eachRow) {
                System.out.printf("%c ", eachChar);
            }
            System.out.println();
        }
    }
}
