package _04_MultidimensionalArrays_Exc;

import java.util.Scanner;

public class _01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",\\s+");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        if ("A".equals(pattern)) {
            printPatternA(size);
        } else if ("B".equals(pattern)) {
            printPatternB(size);
        }
    }

    public static void printPatternA (int size) {
        int[][] multiArr = new int[size][size];
        int num = 1;

        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                multiArr[row][col] = num++;
            }
        }

        printMultiArr(multiArr);
    }

    public static void printPatternB (int size) {
        int[][] multiArr = new int[size][size];
        int num = 1;

        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    multiArr[row][col] = num++;
                }

            } else {
                for (int row = size - 1; row >= 0; row--) {
                    multiArr[row][col] = num++;
                }
            }
        }

        printMultiArr(multiArr);
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
