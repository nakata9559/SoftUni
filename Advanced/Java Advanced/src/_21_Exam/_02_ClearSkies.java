package _21_Exam;

import java.util.Arrays;
import java.util.Scanner;

public class _02_ClearSkies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] protectedAirspace = new char[size][size];
        int[] currentPosition = new int[2];
        int[] nextPosition = new int[2];
        fillMatrix(protectedAirspace, currentPosition, scanner);
        int numOfEnemies = 4;
        int armor = 300;

        while (armor  > 0 && numOfEnemies > 0) {
            String direction = scanner.nextLine();
            nextPosition = moveTo(nextPosition, currentPosition, direction);
            char nextSymbol = protectedAirspace[nextPosition[0]][nextPosition[1]];
            protectedAirspace[currentPosition[0]][currentPosition[1]] = '-';

            switch (nextSymbol) {
                case 'R':
                    armor = 300;
                    break;

                case 'E':
                    if (numOfEnemies > 1) {
                        armor -= 100;
                    }
                    numOfEnemies--;
                    break;
            }

            protectedAirspace[nextPosition[0]][nextPosition[1]] = 'J';
            currentPosition = nextPosition;
        }

        if (numOfEnemies == 0) {
            System.out.println("_08_InterfacesAndAbstraction_Exc._06_MilitaryElite.soldier.privatE.SpecialisedSoldier.Mission accomplished, you neutralized the aerial threat!");
        } else {
            System.out.printf("_08_InterfacesAndAbstraction_Exc._06_MilitaryElite.soldier.privatE.SpecialisedSoldier.Mission failed, your jetfighter was shot down! Last coordinates [%d, %d]!%n",
                    currentPosition[0], currentPosition[1]);
        }

        printMatrix(protectedAirspace);
    }

    public static void fillMatrix(char[][] protectedAirspace, int[] currentPosition, Scanner scanner) {
        for (int row = 0; row < protectedAirspace.length; row++) {
            char[] currentRow = scanner.nextLine().toCharArray();
            protectedAirspace[row] = currentRow;

            for (int col = 0; col < protectedAirspace.length; col++) {
                if (currentRow[col] == 'J') {
                    currentPosition[0] = row;
                    currentPosition[1] = col;
                }
            }
        }
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

    public static void printMatrix(char[][] protectedAirspace) {
        Arrays.stream(protectedAirspace)
                .forEach(row -> System.out.println(String.join("",
                        Arrays.toString(row)
                                .replaceAll("[\\[\\],\\s]", ""))));
    }
}
