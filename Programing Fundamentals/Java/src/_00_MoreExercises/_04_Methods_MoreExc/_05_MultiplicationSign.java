package _00_MoreExercises._04_Methods_MoreExc;

import java.util.Scanner;

public class _05_MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[3];

        for (int i = 0; i < 3; i++) {
            numbers[i] = Integer.parseInt(scanner.nextLine());
        }

        boolean positive = true;
        boolean isZero = false;

        positive = checkIfPositive(numbers);
        isZero = checkIfZero(numbers);

        if (isZero) {
            System.out.println("zero");
        }else if (positive) {
            System.out.println("positive");
        } else {
            System.out.println("negative");
        }
    }

    public static boolean checkIfPositive(int[] numbers) {
        boolean currentAnswerPositive = true;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 && currentAnswerPositive) {
                currentAnswerPositive = false;
            } else if (numbers[i] < 0 && !currentAnswerPositive) {
                currentAnswerPositive = true;
            }
        }
        return currentAnswerPositive;
    }

    public static boolean checkIfZero(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                return true;
            }
        }
        return false;
    }
}
