package _03_MultidimensionalArrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _07_FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] multiArr = new char[8][8];
        for (int row = 0; row < 8; row++) {
            multiArr[row] = fillIntArray(scanner);
        }

        int validRowPosition = -1;
        int validColumnPosition = -1;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                char symCheck = multiArr[row][col];
                boolean isValid;

                isValid = checkTop(multiArr, symCheck, row, col);
                if (!isValid) continue;
                isValid = checkBottom(multiArr, symCheck, row, col);
                if (!isValid) continue;
                isValid = checkLeft(multiArr, symCheck, row, col);
                if (!isValid) continue;
                isValid = checkRight(multiArr, symCheck, row, col);
                if (!isValid) continue;
                isValid = checkTopLeft(multiArr, symCheck, row, col);
                if (!isValid) continue;
                isValid = checkTopRight(multiArr, symCheck, row, col);
                if (!isValid) continue;
                isValid = checkBottomLeft(multiArr, symCheck, row, col);
                if (!isValid) continue;
                isValid = checkBottomRight(multiArr, symCheck, row, col);
                if (!isValid) continue;

                validRowPosition = row;
                validColumnPosition = col;
            }
        }

        System.out.printf("%d %d%n", validRowPosition, validColumnPosition);
    }

    public static char[] fillIntArray(Scanner scanner) {
        return scanner.nextLine().replaceAll("\\s+", "").toCharArray();
    }

    public static boolean checkTop(char[][] multiArr,char symCheck, int row, int col) {
        boolean isValid = true;

        if (row != 0) {
            for (int currentRow = row - 1; currentRow >= 0; currentRow--) {
                char currentSym = multiArr[currentRow][col];
                if (currentSym == symCheck) {
                    return false;
                }
            }
        }

        return isValid;
    }

    public static boolean checkBottom(char[][] multiArr,char symCheck, int row, int col) {
        boolean isValid = true;

        if (row != 7) {
            for (int currentRow = row + 1; currentRow <= 7; currentRow++) {
                char currentSym = multiArr[currentRow][col];
                if (currentSym == symCheck) {
                    return false;
                }
            }
        }

        return isValid;
    }

    public static boolean checkLeft(char[][] multiArr,char symCheck, int row, int col) {
        boolean isValid = true;

        if (col != 0) {
            for (int currentCol = col - 1; currentCol >= 0; currentCol--) {
                char currentSym = multiArr[row][currentCol];
                if (currentSym == symCheck) {
                    return false;
                }
            }
        }

        return isValid;
    }

    public static boolean checkRight(char[][] multiArr,char symCheck, int row, int col) {
        boolean isValid = true;

        if (col != 7) {
            for (int currentCol = col + 1; currentCol <= 7; currentCol++) {
                char currentSym = multiArr[row][currentCol];
                if (currentSym == symCheck) {
                    return false;
                }
            }
        }

        return isValid;
    }

    public static boolean checkTopLeft(char[][] multiArr,char symCheck, int row, int col) {
        boolean isValid = true;

        if (row != 0 && col != 0) {
            int currentRow = row - 1;
            int currentCol = col - 1;
            while (currentRow != -1 && currentCol != -1) {
                char currentSym = multiArr[currentRow][currentCol];
                if (currentSym == symCheck) {
                    return false;
                }
                currentRow--;
                currentCol--;
            }
        }

        return isValid;
    }

    public static boolean checkTopRight(char[][] multiArr,char symCheck, int row, int col) {
        boolean isValid = true;

        if (row != 0 && col != 7) {
            int currentRow = row - 1;
            int currentCol = col + 1;
            while (currentRow != -1 && currentCol != 8) {
                char currentSym = multiArr[currentRow][currentCol];
                if (currentSym == symCheck) {
                    return false;
                }
                currentRow--;
                currentCol++;
            }
        }

        return isValid;
    }

    public static boolean checkBottomLeft(char[][] multiArr,char symCheck, int row, int col) {
        boolean isValid = true;

        if (row != 7 && col != 0) {
            int currentRow = row + 1;
            int currentCol = col - 1;
            while (currentRow != 8 && currentCol != -1) {
                char currentSym = multiArr[currentRow][currentCol];
                if (currentSym == symCheck) {
                    return false;
                }
                currentRow++;
                currentCol--;
            }
        }

        return isValid;
    }

    public static boolean checkBottomRight(char[][] multiArr,char symCheck, int row, int col) {
        boolean isValid = true;

        if (row != 7 && col != 7) {
            int currentRow = row + 1;
            int currentCol = col + 1;
            while (currentRow != 8 && currentCol != 8) {
                char currentSym = multiArr[currentRow][currentCol];
                if (currentSym == symCheck) {
                    return false;
                }
                currentRow++;
                currentCol++;
            }
        }

        return isValid;
    }
}
