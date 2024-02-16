package _20_PastExams._2021_12_December;

import java.util.Arrays;
import java.util.Scanner;

public class _02_ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());
        int[] currentPosition = new int[2];
        int[] nextPosition = new int[2];
        char[][] field = new char[rows][];
        fillMatrix(field, currentPosition, scanner);
        boolean kidnappedHelen = false;

        while (energy > 0 && !kidnappedHelen) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String direction = tokens[0];
            field[currentPosition[0]][currentPosition[1]] = '-';
            int spawnRow = Integer.parseInt(tokens[1]);
            int spawnCol = Integer.parseInt(tokens[2]);
            field[spawnRow][spawnCol] = 'S';

            nextPosition = moveTo(nextPosition, currentPosition, direction);

            int fieldRow = field.length;
            int fieldCol = field[0].length;

            if (checkIfOutOfField(nextPosition, fieldRow, fieldCol)) {
                nextPosition = currentPosition;
                energy--;
                if (energy <= 0) {
                    break;
                }
                continue;
            }

            char nextSymbol = field[nextPosition[0]][nextPosition[1]];

            switch (nextSymbol) {
                case 'S':
                    field[nextPosition[0]][nextPosition[1]] = 'P';
                    energy -= 3;
                    break;

                case 'H':
                    field[nextPosition[0]][nextPosition[1]] = '-';
                    kidnappedHelen = true;
                    energy--;
                    break;

                case '-':
                    field[nextPosition[0]][nextPosition[1]] = 'P';
                    energy--;
                    break;
            }

            currentPosition = nextPosition;
        }

        if (kidnappedHelen) {
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
        } else {
            field[currentPosition[0]][currentPosition[1]] = 'X';
            System.out.printf("Paris died at %d;%d.%n",
                    currentPosition[0],
                    currentPosition[1]);
        }

        printMatrix(field);
    }

    public static int[] moveTo(int[] nextPosition, int[] currentPosition, String direction) {
        switch (direction) {
            case "up":
                nextPosition = new int[] {currentPosition[0] - 1, currentPosition[1]};
                break;

            case "down":
                nextPosition = new int[] {currentPosition[0] + 1, currentPosition[1]};
                break;

            case "left":
                nextPosition = new int[] {currentPosition[0], currentPosition[1] - 1};
                break;

            case "right":
                nextPosition = new int[] {currentPosition[0], currentPosition[1] + 1};
                break;
        }

        return nextPosition;
    }

    public static boolean checkIfOutOfField(int[] nextPosition, int fieldRow, int fieldCol) {
        return nextPosition[0] < 0
                || nextPosition[1] < 0
                || nextPosition[0] >= fieldRow
                || nextPosition[1] >= fieldCol;
    }

    public static void fillMatrix(char[][] field, int[] currentPosition, Scanner scanner) {
        for (int row = 0; row < field.length; row++) {
            char[] currentRow = scanner.nextLine().toCharArray();
            field[row] = currentRow;
            for (int col = 0; col < currentRow.length; col++) {
                if (currentRow[col] == 'P') {
                    currentPosition[0] = row;
                    currentPosition[1] = col;
                    break;
                }
            }
        }
    }

    public static void printMatrix(char[][] field) {
        Arrays.stream(field)
                .forEach(row -> {
                    System.out.println(String.join("",
                            Arrays.toString(row)
                                    .replaceAll("[\\[\\],\\s]", "")));
                });
    }
}