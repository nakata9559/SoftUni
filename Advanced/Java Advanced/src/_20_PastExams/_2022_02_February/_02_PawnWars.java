package _20_PastExams._2022_02_February;

import java.util.Scanner;

public class _02_PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = new char[8][8];
        int[] whiteCurrentPosition = new int[2];
        int[] blackCurrentPosition = new int[2];
        fillMatrix(board, whiteCurrentPosition, blackCurrentPosition, scanner);
        boolean whiteTurn = true;

        while (!checkIfCaptures(whiteCurrentPosition, blackCurrentPosition, whiteTurn)
                && !reachedLastSquare(board, whiteCurrentPosition, blackCurrentPosition, whiteTurn)) {
            whiteTurn = !whiteTurn;
        }
    }

    public static void fillMatrix(char[][] board, int[] whiteCurrentPosition, int[] blackCurrentPosition, Scanner scanner) {
        for (int row = 0; row < board.length; row++) {
            char[] currentRow = scanner.nextLine().toCharArray();
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = currentRow[col];
                if (currentRow[col] == 'b') {
                    blackCurrentPosition[0] = row;
                    blackCurrentPosition[1] = col;
                } else if (currentRow[col] == 'w') {
                    whiteCurrentPosition[0] = row;
                    whiteCurrentPosition[1] = col;
                }
            }
        }
    }

    public static boolean checkIfCaptures(int[] whiteCurrentPosition, int[] blackCurrentPosition, boolean whiteTurn) {
        if (whiteCurrentPosition[0] - 1 == blackCurrentPosition[0]) {
            if (whiteCurrentPosition[1] + 1 == blackCurrentPosition[1]
                || whiteCurrentPosition[1] - 1 == blackCurrentPosition[1]
                || whiteCurrentPosition[1] == blackCurrentPosition[1] + 1
                || whiteCurrentPosition[1] == blackCurrentPosition[1] - 1) {

            if (whiteTurn) {
                System.out.printf("Game over! White capture on %s.%n",
                        convertToCoordinates(blackCurrentPosition));
            } else {
                System.out.printf("Game over! Black capture on %s.%n",
                        convertToCoordinates(whiteCurrentPosition));
            }
            return true;
        }
    }
        return false;
    }

    public static boolean reachedLastSquare(char[][] board, int[] whiteCurrentPosition, int[] blackCurrentPosition, boolean whiteTurn) {
        if (whiteTurn) {
            board[whiteCurrentPosition[0]][whiteCurrentPosition[1]] = '-';
            board[whiteCurrentPosition[0] - 1][whiteCurrentPosition[1]] = 'w';
            whiteCurrentPosition[0] = whiteCurrentPosition[0] - 1;
            if (whiteCurrentPosition[0] == 0) {
                System.out.printf("Game over! White pawn is promoted to a queen at %s.%n",
                        convertToCoordinates(whiteCurrentPosition));
                return true;
            }
        } else {
            board[blackCurrentPosition[0]][blackCurrentPosition[1]] = '-';
            board[blackCurrentPosition[0] + 1][blackCurrentPosition[1]] = 'b';
            blackCurrentPosition[0] = blackCurrentPosition[0] + 1;
            if (blackCurrentPosition[0] == 7) {
                System.out.printf("Game over! Black pawn is promoted to a queen at %s.%n",
                        convertToCoordinates(blackCurrentPosition));
                return true;
            }
        }
        return false;
    }

    public static String convertToCoordinates(int[] currentPosition) {
        String output = Character.valueOf((char) (currentPosition[1] + 97)).toString();
        int position = 8;
        for (int i = 0; i < currentPosition[0]; i++) {
            position--;
        }
        output += String.valueOf(position);

        return output;
    }
}
