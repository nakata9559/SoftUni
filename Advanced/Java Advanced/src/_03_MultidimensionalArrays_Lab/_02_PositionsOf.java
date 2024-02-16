package _03_MultidimensionalArrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _02_PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim = fillArray(scanner);
        int rows = dim[0];
        int cols = dim[1];
        int[][] multiArray = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            multiArray[row] = fillArray(scanner);
        }

        int num = Integer.parseInt(scanner.nextLine());
        boolean found = false;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (num == multiArray[row][col]) {
                    System.out.printf("%d %d%n", row, col);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("not found");
        }
    }

    public static int[] fillArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
