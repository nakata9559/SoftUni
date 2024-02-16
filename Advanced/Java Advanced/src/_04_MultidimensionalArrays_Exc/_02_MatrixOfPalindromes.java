package _04_MultidimensionalArrays_Exc;

import java.util.Arrays;
import java.util.Scanner;

public class _02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim = fillIntArray(scanner);
        int rows = dim[0];
        int cols = dim[1];
        String[][] multiArr = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String firstAndThirdLetter = String.valueOf((char)('a' + row));
                String secondLetter = String.valueOf((char)('a' + row + col));
                multiArr[row][col] = firstAndThirdLetter + secondLetter + firstAndThirdLetter;
            }
        }

        printMultiArr(multiArr);
    }

    public static int[] fillIntArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void printMultiArr(String[][] multiArr) {
        for (String[] eachRow : multiArr) {
            for (String eachNum : eachRow) {
                System.out.printf("%s ", eachNum);
            }
            System.out.println();
        }
    }
}
