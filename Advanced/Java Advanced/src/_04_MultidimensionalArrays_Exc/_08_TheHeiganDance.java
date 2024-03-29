package _04_MultidimensionalArrays_Exc;

import java.util.Arrays;
import java.util.Scanner;

public class _08_TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] chamber = new int[15][15];
        int[] playerPosition = {7,7};
        int playerRow = playerPosition[0];
        int playerCol = playerPosition[1];
        chamber[playerRow][playerCol] = 18500;
        double heiganHPleft = 3000000;
        double damage = Double.parseDouble(scanner.nextLine());
        String currentSpell = "";
        boolean takeCloudDMG = false;

        while (true) {
            heiganHPleft -= damage;

            if (takeCloudDMG) {
                chamber[playerRow][playerCol] -= 3500;
                takeCloudDMG = false;
                if (chamber[playerRow][playerCol] <= 0) {
                    break;
                }
            }

            if (heiganHPleft <= 0) {
                break;
            }

            String[] command = scanner.nextLine().split("\\s+");
            currentSpell = command[0];
            int currentRow = Integer.parseInt(command[1]);
            int currentCol = Integer.parseInt(command[2]);
            int previousRow = currentRow - 1;
            int nextRow = currentRow + 1;
            int previousCol = currentCol - 1;
            int nextCol = currentCol + 1;
            int[][] affectedPositions = {
                    {previousRow, previousCol},
                    {previousRow, currentCol},
                    {previousRow, nextCol},
                    {currentRow, previousCol},
                    {currentRow, currentCol},
                    {currentRow, nextCol},
                    {nextRow, previousCol},
                    {nextRow, currentCol},
                    {nextRow, nextCol}
            };
            boolean isCloud = false;
            if (currentSpell.equals("Cloud")) {
                isCloud = true;
            }

            for (int i = 0; i < 9; i++) {
                if (Arrays.equals(affectedPositions[i], playerPosition)) {
                    switch (i) {
                        case 0:
                            if (playerRow - 1 >= 0) {
                                chamber[playerRow - 1][playerCol] = chamber[playerRow][playerCol];
                                playerPosition[0] = playerRow - 1;
                                chamber[playerRow][playerCol] = 0;
                            } else if (playerCol - 1 >= 0) {
                                chamber[playerRow][playerCol - 1] = chamber[playerRow][playerCol];
                                playerPosition[1] = playerCol - 1;
                                chamber[playerRow][playerCol] = 0;
                            } else {
                                if (isCloud) {
                                    chamber[playerRow][playerCol] -= 3500;
                                    takeCloudDMG = true;
                                } else {
                                    chamber[playerRow][playerCol] -= 6000;
                                }
                            }
                            break;

                        case 1:
                            if (playerRow - 1 >= 0) {
                                chamber[playerRow - 1][playerCol] = chamber[playerRow][playerCol];
                                playerPosition[0] = playerRow - 1;
                                chamber[playerRow][playerCol] = 0;
                            } else {
                                if (isCloud) {
                                    chamber[playerRow][playerCol] -= 3500;
                                    takeCloudDMG = true;
                                } else {
                                    chamber[playerRow][playerCol] -= 6000;
                                }
                            }
                            break;

                        case 2:
                            if (playerRow - 1 >= 0) {
                                chamber[playerRow - 1][playerCol] = chamber[playerRow][playerCol];
                                playerPosition[0] = playerRow - 1;
                                chamber[playerRow][playerCol] = 0;
                            } else if (playerCol + 1 <= 14) {
                                chamber[playerRow][playerCol + 1] = chamber[playerRow][playerCol];
                                playerPosition[1] = playerCol + 1;
                                chamber[playerRow][playerCol] = 0;
                            } else {
                                if (isCloud) {
                                    chamber[playerRow][playerCol] -= 3500;
                                    takeCloudDMG = true;
                                } else {
                                    chamber[playerRow][playerCol] -= 6000;
                                }
                            }
                            break;

                        case 3:
                            if (playerCol - 1 >= 0) {
                                chamber[playerRow][playerCol - 1] = chamber[playerRow][playerCol];
                                playerPosition[1] = playerCol - 1;
                                chamber[playerRow][playerCol] = 0;
                            } else {
                                if (isCloud) {
                                    chamber[playerRow][playerCol] -= 3500;
                                    takeCloudDMG = true;
                                } else {
                                    chamber[playerRow][playerCol] -= 6000;
                                }
                            }
                            break;

                        case 4:
                            if (isCloud) {
                                chamber[playerRow][playerCol] -= 3500;
                                takeCloudDMG = true;
                            } else {
                                chamber[playerRow][playerCol] -= 6000;
                            }
                            break;

                        case 5:
                            if (playerCol + 1 <= 14) {
                                chamber[playerRow][playerCol + 1] = chamber[playerRow][playerCol];
                                playerPosition[1] = playerCol + 1;
                                chamber[playerRow][playerCol] = 0;
                            } else {
                                if (isCloud) {
                                    chamber[playerRow][playerCol] -= 3500;
                                    takeCloudDMG = true;
                                } else {
                                    chamber[playerRow][playerCol] -= 6000;
                                }
                            }
                            break;

                        case 6:
                            if (playerRow + 1 <= 14) {
                                chamber[playerRow + 1][playerCol] = chamber[playerRow][playerCol];
                                playerPosition[0] = playerRow + 1;
                                chamber[playerRow][playerCol] = 0;
                            } else if (playerCol - 1 >= 0) {
                                chamber[playerRow][playerCol - 1] = chamber[playerRow][playerCol];
                                playerPosition[1] = playerCol - 1;
                                chamber[playerRow][playerCol] = 0;
                            } else {
                                if (isCloud) {
                                    chamber[playerRow][playerCol] -= 3500;
                                    takeCloudDMG = true;
                                } else {
                                    chamber[playerRow][playerCol] -= 6000;
                                }
                            }
                            break;

                        case 7:
                            if (playerRow + 1 <= 14) {
                                chamber[playerRow + 1][playerCol] = chamber[playerRow][playerCol];
                                playerPosition[0] = playerRow + 1;
                                chamber[playerRow][playerCol] = 0;
                            } else {
                                if (isCloud) {
                                    chamber[playerRow][playerCol] -= 3500;
                                    takeCloudDMG = true;
                                } else {
                                    chamber[playerRow][playerCol] -= 6000;
                                }
                            }
                            break;

                        case 8:
                            if (playerCol + 1 <= 14) {
                                chamber[playerRow][playerCol + 1] = chamber[playerRow][playerCol];
                                playerPosition[1] = playerCol + 1;
                                chamber[playerRow][playerCol] = 0;
                            } else if (playerRow + 1 <= 14) {
                                chamber[playerRow + 1][playerCol] = chamber[playerRow][playerCol];
                                playerPosition[0] = playerRow + 1;
                                chamber[playerRow][playerCol] = 0;
                            } else {
                                if (isCloud) {
                                    chamber[playerRow][playerCol] -= 3500;
                                    takeCloudDMG = true;
                                } else {
                                    chamber[playerRow][playerCol] -= 6000;
                                }
                            }
                            break;
                    }
                }
            }

            playerRow = playerPosition[0];
            playerCol = playerPosition[1];

             if (chamber[playerRow][playerCol] <= 0) {
                break;
            }
        }
        if (currentSpell.equals("Cloud")) {
            currentSpell = "Plague Cloud";
        }

        if (heiganHPleft <= 0) {
            if (chamber[playerRow][playerCol] <= 0) {
                chamber[playerRow][playerCol] = 0;
            }
            System.out.printf("Heigan: Defeated!%n" +
                            "_04_Encapsulation_Exc._05_FootballTeamGenerator.Player: %d%n" +
                            "Final position: %d, %d%n",
                    chamber[playerRow][playerCol],
                    playerRow,
                    playerCol);
        } else {
            System.out.printf("Heigan: %.2f%n" +
                            "_04_Encapsulation_Exc._05_FootballTeamGenerator.Player: Killed by %s%n" +
                            "Final position: %d, %d%n",
                    heiganHPleft,
                    currentSpell,
                    playerRow,
                    playerCol);
        }
    }
}
