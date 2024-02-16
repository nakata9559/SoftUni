package _04_MultidimensionalArrays_Exc;

import java.util.Arrays;
import java.util.Scanner;

public class _05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim = fillIntArray(scanner);
        int rows = dim[0];
        int cols = dim[1];
        String[][] multiArr = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            multiArr[row] = scanner.nextLine().split("\\s+");
        }

        while (true) {
            String[] commands = scanner.nextLine().split("\\s+");
            if ("END".equals(commands[0])) {
                break;
            }

            String command = commands[0];
            if (!"swap".equals(command)
            || commands.length != 5) {
                System.out.println("Invalid input!");
                continue;
            }
            int row1 = Integer.parseInt(commands[1]);
            int col1 = Integer.parseInt(commands[2]);
            int row2 = Integer.parseInt(commands[3]);
            int col2 = Integer.parseInt(commands[4]);

            if (row1 >= rows
                    || row2 >= rows
                    || col1 >= cols
                    || col2 >= cols) {
                System.out.println("Invalid input!");
                continue;
            }

            String buffer = multiArr[row1][col1];
            multiArr[row1][col1] = multiArr[row2][col2];
            multiArr[row2][col2] = buffer;
            printMultiArr(multiArr);
        }
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