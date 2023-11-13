package _16_TextProcessing_Exc;

import java.util.Scanner;

public class _02_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int totalSum;

        if (input[0].length() < input[1].length()) {
            totalSum = sumMultiplied(input[0], input[1])
                    + sumOfRemaining(input[1], input[1].length() - input[0].length());

        } else if (input[0].length() > input[1].length()) {
            totalSum = sumMultiplied(input[1], input[0])
                    + sumOfRemaining(input[0], input[0].length() - input[1].length());

        } else {
            totalSum = sumMultiplied(input[0], input[1]);
        }

        System.out.println(totalSum);
    }

    public static int sumMultiplied(String firstWord, String secondWord) {
        int sumTotal = 0;

        for (int i = 0; i < firstWord.length(); i++) {
            sumTotal += firstWord.charAt(i) * secondWord.charAt(i);
        }

        return sumTotal;
    }

    public static int sumOfRemaining(String word, int difference) {
        int sum = 0;

        for (int i = word.length() - 1; i > word.length() - 1 - difference ; i--) {
            sum += word.charAt(i);
        }

        return sum;
    }
}
