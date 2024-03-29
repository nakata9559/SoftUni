package _15_ExceptionsAndErrorHandling;

import java.util.Arrays;
import java.util.Scanner;

public class _03_EnterNumbers {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static int[] output;
    private static int index;

    public static void main(String[] args) {
        output = new int[10];
        int start = 1;
        int end = 100;

        readNumber(start, end);

        System.out.println(String.join(", ", Arrays.stream(output)
                .mapToObj(String::valueOf)
                .toArray(String[]::new)));
    }

    public static void readNumber(int start, int end) {
        String input = SCANNER.nextLine();

        try {
            int num = Integer.parseInt(input);

            if (num <= start || num >= end) {
                throw new IllegalArgumentException(
                        String.format("Your number is not in range %d - %d!", start, end));
            }

            output[index++] = num;
            start = num;

        } catch (NumberFormatException e) {
            System.out.println("Invalid Number!");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        } finally {
            if (index <= 9) {
                readNumber(start, end);
            }
        }
    }
}
