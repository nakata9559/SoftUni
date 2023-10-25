package _00_MoreExercises._03_Arrays_MoreExc;

import java.util.Arrays;
import java.util.Scanner;

public class _06_LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());

        int[] lBugInitialPositionIndex =
                Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int[] ladyBugField = new int[fieldSize];

        for (int i = 0; i < ladyBugField.length; i++) {
            for (int j = 0; j < lBugInitialPositionIndex.length; j++) {
                if (lBugInitialPositionIndex[j] == i)
                {
                    ladyBugField[i] = 1;
                }
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] rules = Arrays.stream(command.split(" "))
                    .map(String::valueOf)
                    .toArray(String[]::new);

            int initialPosition = Integer.parseInt(rules[0]);
            String direction = rules[1];
            int countOfMoves = Integer.parseInt(rules[2]);

            int newPosition = 0;

            if (countOfMoves < 0) {
                if (direction.equals("left")) {
                    direction = "right";
                    countOfMoves = Math.abs(countOfMoves);

                } else if (direction.equals("right")) {
                    direction = "left";
                    countOfMoves = Math.abs(countOfMoves);
                }
            }

            if (initialPosition < 0
                    || initialPosition > ladyBugField.length - 1
                    || ladyBugField[initialPosition] == 0) {
                command = scanner.nextLine();;
                continue;
            }

            if (countOfMoves == 0 && initialPosition <= ladyBugField.length - 1) {
                if (ladyBugField[initialPosition] == 1) {
                    ladyBugField[initialPosition] = 0;
                }

            }

            switch (direction) {

                case "right":

                    newPosition = initialPosition + countOfMoves;

                    ladyBugField[initialPosition] = 0;

                    if (newPosition > ladyBugField.length - 1) {
                        ladyBugField[initialPosition] = 0;
                        break;

                    } else {
                        for (int i = newPosition; i < ladyBugField.length; i += countOfMoves) {
                            if (ladyBugField[i] == 0)
                            {
                                ladyBugField[i] = 1;
                                break;
                            }
                        }
                    }
                    break;

                case "left":

                    newPosition = initialPosition - countOfMoves;

                    ladyBugField[initialPosition] = 0;
                    if (newPosition < 0) {
                        ladyBugField[initialPosition] = 0;
                        break;

                    } else {
                        for (int i = newPosition; i >= 0; i -= countOfMoves) {
                            if (ladyBugField[i] == 0) {
                                ladyBugField[i] = 1;
                                break;
                            }
                        }
                    }
                    break;
            }

            command = scanner.nextLine();
        }
        System.out.println(String.join(" ", Arrays.stream(ladyBugField)
                .mapToObj(String::valueOf)
                .toArray(String[]::new)));

    }
}

