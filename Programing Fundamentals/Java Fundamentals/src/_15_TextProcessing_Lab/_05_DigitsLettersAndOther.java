package _15_TextProcessing_Lab;

import java.util.Scanner;

public class _05_DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder firstLine = new StringBuilder();
        StringBuilder secondLine = new StringBuilder();
        StringBuilder thirdLine = new StringBuilder();

        /*String firstLine = input.replaceAll("\\D+", "");
        String secondLine = input.replaceAll("\\W+|\\d+", "");
        String thirdLine = input.replaceAll("\\w+|\\d+", "");*/

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isDigit(ch)) {
                firstLine.append(ch);

            } else if (Character.isAlphabetic(ch)) {
                secondLine.append(ch);

            } else {
                thirdLine.append(ch);
            }
        }

        System.out.printf("%s\n%s\n%s\n", firstLine, secondLine, thirdLine);
    }
}
