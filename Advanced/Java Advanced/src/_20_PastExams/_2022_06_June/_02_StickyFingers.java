package _20_PastExams._2022_06_June;

import java.util.Arrays;
import java.util.Scanner;

public class _02_StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(",");

        char[][] field = new char[fieldSize][fieldSize];
        int[] currentPosition = fillCharMatrix(field, scanner);
        int totalStolen = 0;

        for (String command : commands) {
            int[] nextPosition = checkIfMoving(command, currentPosition, fieldSize);

            if (nextPosition != currentPosition) {
                field[currentPosition[0]][currentPosition[1]] = '+';
                char nextSymbol = field[nextPosition[0]][nextPosition[1]];

                switch (nextSymbol) {
                    case '+':
                        field[nextPosition[0]][nextPosition[1]] = 'D';
                        break;

                    case '$':
                        field[nextPosition[0]][nextPosition[1]] = 'D';
                        System.out.println("You successfully stole " + nextPosition[0] * nextPosition[1] + "$.");
                        totalStolen += nextPosition[0] * nextPosition[1];
                        break;

                    case 'P':
                        field[nextPosition[0]][nextPosition[1]] = '#';
                        System.out.println("You got caught with " + totalStolen + "$, and you are going to jail.");
                        printField(field);
                        return;
                }
                currentPosition = nextPosition;
            }
        }
        System.out.println("Your last theft has finished successfully with " + totalStolen + "$ in your pocket.");
        printField(field);
    }

    public static int[] fillCharMatrix(char[][] field, Scanner scanner) {
        int[] position = new int[2];

        for (int row = 0; row < field.length ; row++) {
            char[] currentRow = scanner.nextLine().replaceAll(" ", "").toCharArray();
            for (int col = 0; col < field[row].length; col++) {
                field[row][col] = currentRow[col];
                if (currentRow[col] == 'D') {
                    position[0] = row;
                    position[1] = col;
                }
            }
        }

        return position;
    }

    public static int[] checkIfMoving(String command, int[] currentPosition, int fieldSize) {
        int[] nextPosition = currentPosition;

        switch (command) {
            case "up":
                nextPosition = new int[]{currentPosition[0] - 1, currentPosition[1]};
                break;

            case "down":
                nextPosition = new int[]{currentPosition[0] + 1, currentPosition[1]};
                break;

            case "left":
                nextPosition = new int[]{currentPosition[0], currentPosition[1] - 1};
                break;

            case "right":
                nextPosition = new int[]{currentPosition[0], currentPosition[1] + 1};
                break;
        }

        if (outOfField(nextPosition, fieldSize)) {
            System.out.println("You cannot leave the town, there is police outside!");
            return currentPosition;
        } else {
            return nextPosition;
        }
    }

    public static boolean outOfField(int[] nextPosition, int fieldSize) {
        return nextPosition[0] < 0
                || nextPosition[1] < 0
                || nextPosition[0] >= fieldSize
                || nextPosition[1] >= fieldSize;
    }

    public static void printField(char[][] field) {
        for (char[] row : field) {
            System.out.println(String.join(" ", Arrays.toString(row).replaceAll("[\\[\\],]", "")));
        }
    }
}
