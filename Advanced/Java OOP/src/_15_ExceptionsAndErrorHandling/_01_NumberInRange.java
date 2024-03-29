package _15_ExceptionsAndErrorHandling;

import java.util.Arrays;
import java.util.Scanner;

public class _01_NumberInRange {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static int[] range;

    public static void main(String[] args) {
        range = Arrays.stream(SCANNER.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = SCANNER.nextLine();

        System.out.printf("Range: [%d...%d]%n", range[0], range[1]);

        System.out.println("Valid number: " + checkIfValid(input));
    }

    private static String checkIfValid(String input) {
        try {
            int num = Integer.parseInt(input);
            if (num < range[0] || num > range[1]) {
                throw new IllegalArgumentException();
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid number: " + input);
            input = checkIfValid(SCANNER.nextLine());
        }

        return input;
    }
}
