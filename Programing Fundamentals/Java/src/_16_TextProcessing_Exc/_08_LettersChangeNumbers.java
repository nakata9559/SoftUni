package _16_TextProcessing_Exc;

import java.util.Scanner;

public class _08_LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] texts = scanner.nextLine().split("\\s+");

        double result = 0;

        for (String text : texts) {
            double currentSum = 0;
            double currentNumber = Double.parseDouble(text.replaceAll("\\D+", ""));

            if (text.charAt(0) >= 'A'
                    && text.charAt(0) <= 'Z') {
                currentSum = currentNumber / (text.charAt(0) - 64);

            } else if (text.charAt(0) >= 'a'
                    && text.charAt(0) <= 'z') {
                currentSum = currentNumber * (text.charAt(0) - 96);
            }

            result += currentSum;

            if (text.charAt(text.length() - 1) >= 'A'
                    && text.charAt(text.length() - 1) <= 'Z') {
                result -= text.charAt(text.length() - 1) - 64;

            } else if (text.charAt(text.length() - 1) >= 'a'
                    && text.charAt(text.length() - 1) <= 'z')  {
                result += text.charAt(text.length() - 1) - 96;

            }
        }

        System.out.printf("%.2f\n", result);
    }
}
