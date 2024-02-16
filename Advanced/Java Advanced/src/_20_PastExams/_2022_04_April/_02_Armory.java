package _20_PastExams._2022_04_April;

import java.util.Arrays;
import java.util.Scanner;

public class _02_Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] armory = new char[size][size];
        int[] currentPosition = new int[2];
        int[] mirror1Position = new int[2];
        int[] mirror2Position = new int[2];
        fillCharMatrix(armory, scanner, currentPosition, mirror1Position, mirror2Position);
        int swordsPrice = 0;
        boolean leftArmory = false;

        while (true) {
            int[] nextPosition = moveTo(scanner.nextLine(), currentPosition);
            armory[currentPosition[0]][currentPosition[1]] = '-';
            leftArmory = checkIfLeft(nextPosition, size);
            if (leftArmory) {
                break;
            }

            char nextSymbol = armory[nextPosition[0]][nextPosition[1]];

            if (Character.isDigit(nextSymbol)) {
                swordsPrice += Character.getNumericValue(nextSymbol);
                currentPosition = nextPosition;
                armory[nextPosition[0]][nextPosition[1]] = 'A';
                if (swordsPrice >= 65) {
                    break;
                }

            } else if (nextSymbol == 'M') {
                if (Arrays.equals(nextPosition, mirror1Position)) {
                    armory[mirror2Position[0]][mirror2Position[1]] = 'A';
                    armory[nextPosition[0]][nextPosition[1]] = '-';
                    currentPosition = mirror2Position;
                } else {
                    armory[mirror1Position[0]][mirror1Position[1]] = 'A';
                    armory[nextPosition[0]][nextPosition[1]] = '-';
                    currentPosition = mirror1Position;
                }

            } else if (nextSymbol == '-') {
                currentPosition = nextPosition;
            }
        }

        if (leftArmory) {
            System.out.println("I do not need more swords!");
        } else {
            System.out.println("Very nice swords, I will come back for more!");
        }

        System.out.printf("The king paid %d gold coins.%n", swordsPrice);
        printArmory(armory);
    }

    public static void fillCharMatrix(char[][] armory, Scanner scanner, int[] currentPosition, int[] mirror1Position, int[] mirror2Position) {
        boolean firstMirror = true;
        for (int row = 0; row < armory.length ; row++) {
            char[] currentRow = scanner.nextLine().replaceAll(" ", "").toCharArray();
            for (int col = 0; col < armory[row].length; col++) {
                armory[row][col] = currentRow[col];
                if (currentRow[col] == 'A') {
                    currentPosition[0] = row;
                    currentPosition[1] = col;
                }
                if (firstMirror) {
                    if (currentRow[col] == 'M') {
                        mirror1Position[0] = row;
                        mirror1Position[1] = col;
                        firstMirror = false;
                    }
                } else {
                    if (currentRow[col] == 'M') {
                        mirror2Position[0] = row;
                        mirror2Position[1] = col;
                    }
                }
            }
        }
    }

    public static int[] moveTo(String command, int[] currentPosition) {
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
        return nextPosition;
    }

    public static boolean checkIfLeft(int[] nextPosition, int size){
        return nextPosition[0] < 0
                || nextPosition[1] < 0
                || nextPosition[0] >= size
                || nextPosition[1] >= size;
    }

    public static void printArmory(char[][] armory) {
        for (char[] row : armory) {
            System.out.println(String.join("",
                    Arrays.toString(row)
                            .replaceAll("[\\[\\],\\s]", "")));
        }
    }
}
