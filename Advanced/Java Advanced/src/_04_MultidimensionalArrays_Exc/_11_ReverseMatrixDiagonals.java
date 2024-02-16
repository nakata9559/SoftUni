package _04_MultidimensionalArrays_Exc;

import java.util.*;

public class _11_ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim = fillIntArray(scanner);
        int rows = dim[0];
        int cols = dim[1];
        String[][] multiArr = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            multiArr[row] = scanner.nextLine().split(" ");
        }

        String[][] outputArr = new String[rows + cols - 1][rows];

        int currentRow = rows - 1;
        int currentCol = cols - 1;
        int eachRow = 0;
        int eachTriangle = 0;

        for (int i = 0; i < rows * cols; i++) {
            outputArr[eachRow++][eachTriangle] = multiArr[currentRow][currentCol];

            if (currentRow - 1 < 0 && currentCol - 1 < eachTriangle) {
                eachTriangle++;
                currentRow = rows - 1 - eachTriangle;
                currentCol = cols - 1;
            } else if (currentCol - 1 >= eachTriangle) {
                currentCol--;
            } else if  (currentRow - 1 >= 0) {
                currentRow--;
            }

            if (eachRow >= rows + cols - 1 - eachTriangle) {
                eachRow = eachTriangle;
            }
        }

        printMultiArr(outputArr);
    }

    public static int[] fillIntArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void printMultiArr(String[][] multiArr) {
        for (String[] eachRow : multiArr) {
            for (String eachNum : eachRow) {
                if (eachNum != null) {
                    System.out.printf("%s ", eachNum);
                }
            }
            System.out.println();
        }
    }
}
