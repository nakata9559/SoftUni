package _00_MoreExercises._03_Arrays_MoreExc;

import java.util.Arrays;
import java.util.Scanner;

public class _02_PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[] previousRow = new int[rows];

        for (int i = 0; i < rows; i++) {
            int[] rowsArray = new int[rows];
            rowsArray[0] = 1;
            previousRow[0] = 1;


            if (i >= 1) {
                for (int j = 1; j < rowsArray.length; j++) {
                    rowsArray[j] = previousRow[j] + previousRow[j - 1];
                }
            }

            previousRow = rowsArray;

            rowsArray = Arrays.copyOf(rowsArray, i + 1);

            System.out.println(String
                    .join(" ", Arrays.stream(rowsArray)
                    .mapToObj(String::valueOf)
                    .toArray(String[]::new)));
        }
    }
}
