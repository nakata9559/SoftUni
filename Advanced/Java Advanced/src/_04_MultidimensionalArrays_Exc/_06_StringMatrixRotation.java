package _04_MultidimensionalArrays_Exc;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _06_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int degree = Integer.parseInt(scanner.nextLine().replaceAll("[^0-9]+", ""));
        Deque<String> words = new ArrayDeque<>();
        int longestWordLength = Integer.MIN_VALUE;

        while (true){
            String input = scanner.nextLine();
            if ("END".equals(input)) {
                break;
            }
            if (input.length() > longestWordLength) {
                longestWordLength = input.length();
            }
            words.offer(input);
        }

        int rotateTimes = 0;

        for (int i = 0; i <= 1000; i++) {
            if (degree / 90 == i) {
                for (int j = 0; j < i; j++) {
                    rotateTimes++;
                    if (rotateTimes == 4) {
                        rotateTimes = 0;
                    }
                }
            }
        }

        switch (rotateTimes) {
            case 0:
                noRotation(words, longestWordLength, words.size());
                break;
            case 1:
                rotateOnce(words, longestWordLength, words.size());
                break;
            case 2:
                rotateTwice(words, longestWordLength, words.size());
                break;
            case 3:
                rotateThreeTimes(words, longestWordLength, words.size());
                break;
        }
    }
    public static void printMultiArr(String[][] multiArr) {
        for (String[] eachRow : multiArr) {
            for (String eachNum : eachRow) {
                System.out.printf("%s", eachNum);
            }
            System.out.println();
        }
    }

    public static void noRotation(Deque<String> words, int cols, int rows) {
        String[][] multiArr = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            int wordLength = words.peek().length();
            char[] currentWord = words.poll().toCharArray();
            int currentWordIndex = 0;
            for (int col = 0; col < cols; col++) {
                if (wordLength > col) {
                    multiArr[row][col] = String.valueOf(currentWord[currentWordIndex++]);
                } else {
                    multiArr[row][col] = " ";
                }
            }
        }

        printMultiArr(multiArr);
    }

    public static void rotateOnce(Deque<String> words, int rows, int cols) {
        String[][] multiArr = new String[rows][cols];

        for (int col = cols - 1; col >= 0; col--) {
            int wordLength = words.peek().length();
            char[] currentWord = words.poll().toCharArray();
            int currentWordIndex = 0;
            for (int row = 0; row < rows; row++) {
                if (wordLength > row) {
                    multiArr[row][col] = String.valueOf(currentWord[currentWordIndex++]);
                } else {
                    multiArr[row][col] = " ";
                }
            }
        }

        printMultiArr(multiArr);
    }

    public static void rotateTwice(Deque<String> words, int cols, int rows) {
        String[][] multiArr = new String[rows][cols];

        for (int row = rows - 1; row >= 0; row--) {
            int wordLength = words.peek().length();
            char[] currentWord = words.poll().toCharArray();
            int currentWordIndex = 0;
            for (int col = cols - 1; col >= 0; col--) {
                if (wordLength > cols - 1 - col) {
                    multiArr[row][col] = String.valueOf(currentWord[currentWordIndex++]);
                } else {
                    multiArr[row][col] = " ";
                }
            }
        }

        printMultiArr(multiArr);
    }

    public static void rotateThreeTimes(Deque<String> words, int rows, int cols) {
        String[][] multiArr = new String[rows][cols];

        for (int col = 0; col < cols; col++) {
            int wordLength = words.peek().length();
            char[] currentWord = words.poll().toCharArray();
            int currentWordIndex = 0;
            for (int row = rows - 1; row >= 0; row--) {
                if (wordLength > rows - 1 - row) {
                    multiArr[row][col] = String.valueOf(currentWord[currentWordIndex++]);
                } else {
                    multiArr[row][col] = " ";
                }
            }
        }

        printMultiArr(multiArr);
    }
}
