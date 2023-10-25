package _00_MoreExercises._04_Methods_MoreExc;

import java.util.Arrays;
import java.util.Scanner;

public class _06_ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers =
                Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        String[] command = scanner.nextLine().split(" ");

        while (!command[0].equals("end")) {
            switch (command[0]) {
                case "exchange":
                    if (Integer.parseInt(command[1]) >= numbers.length
                    || Integer.parseInt(command[1]) < 0) {
                        System.out.println("Invalid index");
                        break;
                    }
                    numbers = returnExchanged(numbers, Integer.parseInt(command[1]));
                    break;

                case "max":
                    printMax(numbers, command[1]);
                    break;

                case "min":
                    printMin(numbers, command[1]);
                    break;

                case "first":
                    if (Integer.parseInt(command[1]) > numbers.length) {
                        System.out.println("Invalid count");
                        break;
                    }
                    printFirst(numbers, Integer.parseInt(command[1]), command[2]);
                    break;

                case "last":
                    if (Integer.parseInt(command[1]) > numbers.length) {
                        System.out.println("Invalid count");
                        break;
                    }
                    printLast(numbers, Integer.parseInt(command[1]), command[2]);
                    break;
            }

            command = scanner.nextLine().split(" ");
        }
        System.out.println("[" + String.join(", ", Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new)) + "]");
    }

    public static int[] returnExchanged(int[] numbers, int exchangeIndex) {
        int[] leftNumbers = new int[numbers.length - exchangeIndex - 1];
        int[] rightNumbers = new int[exchangeIndex + 1];
        int[] exchangedNumbers = new int[numbers.length];

        for (int i = 0; i < leftNumbers.length; i++) {
            leftNumbers[i] = numbers[i + exchangeIndex + 1];
        }

        for (int i = 0; i < rightNumbers.length; i++) {
            rightNumbers[i] = numbers[i];
        }

        for (int i = 0; i < exchangedNumbers.length; i++) {
            if (i < leftNumbers.length) {
                exchangedNumbers[i] = leftNumbers[i];
            } else {
                exchangedNumbers[i] = rightNumbers[i - leftNumbers.length];
            }
        }
        return exchangedNumbers;
    }

    public static void printMax(int[] numbers, String oddOrEven) {
        boolean oddExists = false;
        boolean evenExists = false;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenExists = true;
            } else {
                oddExists = true;
            }
        }

        int maxIndex = 0;
        int currentNum = Integer.MIN_VALUE;

        if (oddOrEven.equals("odd")) {
            if (oddExists) {
                for (int i = 0; i < numbers.length; i++) {
                    if (numbers[i] % 2 != 0 && numbers[i] >= currentNum) {
                        maxIndex = i;
                        currentNum = numbers[i];
                    }
                }
                System.out.println(maxIndex);

            } else {
                System.out.println("No matches");
            }
        }

        if (oddOrEven.equals("even")) {
            if (evenExists) {
                for (int i = 0; i < numbers.length; i++) {
                    if (numbers[i] % 2 == 0 && numbers[i] >= currentNum) {
                        maxIndex = i;
                        currentNum = numbers[i];
                    }
                }
                System.out.println(maxIndex);

            } else {
                System.out.println("No matches");
            }
        }
    }

    public static void printMin(int[] numbers, String oddOrEven) {
        boolean oddExists = false;
        boolean evenExists = false;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenExists = true;
            } else {
                oddExists = true;
            }
        }

        int minIndex = 0;
        int currentNum = Integer.MAX_VALUE;

        if (oddOrEven.equals("odd")) {
            if (oddExists) {
                for (int i = 0; i < numbers.length; i++) {
                    if (numbers[i] % 2 != 0 && numbers[i] <= currentNum) {
                        minIndex = i;
                        currentNum = numbers[i];
                    }
                }
                System.out.println(minIndex);

            } else {
                System.out.println("No matches");
            }
        }

        if (oddOrEven.equals("even")) {
            if (evenExists) {
                for (int i = 0; i < numbers.length; i++) {
                    if (numbers[i] % 2 == 0 && numbers[i] <= currentNum) {
                        minIndex = i;
                        currentNum = numbers[i];
                    }
                }
                System.out.println(minIndex);

            } else {
                System.out.println("No matches");
            }
        }
    }

    public static void printFirst(int[] numbers, int count, String oddOrEven) {
        int countOddNumbers = 0;
        int countEvenNumbers = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                countEvenNumbers++;
            } else {
                countOddNumbers++;
            }
        }

        int[] oddArray = new int[countOddNumbers];
        int[] evenArray = new int[countEvenNumbers];
        int oddArrayIndex = 0;
        int evenArrayIndex = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                oddArray[oddArrayIndex] = numbers[i];
                oddArrayIndex++;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenArray[evenArrayIndex] = numbers[i];
                evenArrayIndex++;
            }
        }

        switch (oddOrEven) {
            case "odd":
                int numOfOddIndexes = 0;

                if (oddArray.length == 0) {
                    System.out.println("[]");
                    break;
                }

                if (oddArray.length > count) {
                    numOfOddIndexes = count;
                } else {
                    numOfOddIndexes = oddArray.length;
                }

                int[] firstOdds = new int[numOfOddIndexes];

                for (int i = 0; i < numOfOddIndexes; i++) {
                    firstOdds[i] = oddArray[i];
                }

                System.out.println("[" + String.join(", ", Arrays.stream(firstOdds)
                        .mapToObj(String::valueOf)
                        .toArray(String[]::new)) + "]");
                break;

            case "even":
                int numOfEvenIndexes = 0;

                if (evenArray.length == 0) {
                    System.out.println("[]");
                    break;
                }

                if (evenArray.length > count) {
                    numOfEvenIndexes = count;
                } else {
                    numOfEvenIndexes = evenArray.length;
                }

                int[] firstEvens = new int[numOfEvenIndexes];

                for (int i = 0; i < numOfEvenIndexes; i++) {
                    firstEvens[i] = evenArray[i];
                }

                System.out.println("[" + String.join(", ", Arrays.stream(firstEvens)
                        .mapToObj(String::valueOf)
                        .toArray(String[]::new)) + "]");
                break;
        }
    }


    public static void printLast(int[] numbers, int count, String oddOrEven) {
        int countOddNumbers = 0;
        int countEvenNumbers = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                countEvenNumbers++;
            } else {
                countOddNumbers++;
            }
        }

        int[] oddArray = new int[countOddNumbers];
        int[] evenArray = new int[countEvenNumbers];
        int oddArrayIndex = 0;
        int evenArrayIndex = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                oddArray[oddArrayIndex] = numbers[i];
                oddArrayIndex++;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenArray[evenArrayIndex] = numbers[i];
                evenArrayIndex++;
            }
        }

        switch (oddOrEven) {
            case "odd":
                int numOfOddIndexes = 0;

                if (oddArray.length == 0) {
                    System.out.println("[]");
                    break;
                }

                if (oddArray.length > count) {
                    numOfOddIndexes = count;
                } else {
                    numOfOddIndexes = oddArray.length;
                }

                int[] lastOdds = new int[numOfOddIndexes];

                for (int i = 0; i < numOfOddIndexes; i++) {
                    lastOdds[numOfOddIndexes - 1 - i] = oddArray[oddArray.length - 1 -i];
                }

                System.out.println("[" + String.join(", ", Arrays.stream(lastOdds)
                        .mapToObj(String::valueOf)
                        .toArray(String[]::new)) + "]");
                break;

            case "even":
                int numOfEvenIndexes = 0;

                if (evenArray.length == 0) {
                    System.out.println("[]");
                    break;
                }

                if (evenArray.length > count) {
                    numOfEvenIndexes = count;
                } else {
                    numOfEvenIndexes = evenArray.length;
                }

                int[] lastEvens = new int[numOfEvenIndexes];

                for (int i = 0; i < numOfEvenIndexes; i++) {
                    lastEvens[numOfEvenIndexes - 1 - i] = evenArray[evenArray.length - 1 - i];
                }

                System.out.println("[" + String.join(", ", Arrays.stream(lastEvens)
                        .mapToObj(String::valueOf)
                        .toArray(String[]::new)) + "]");
                break;
        }
    }
}
