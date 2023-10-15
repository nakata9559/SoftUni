package _08_Methods_Exc;

import java.util.Scanner;

public class _09_PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            printIfIsPalindrome(input);

            input = scanner.nextLine();
        }
    }

    public static void printIfIsPalindrome(String input) {
        String inputBackwards = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            inputBackwards += input.charAt(i);
        }

        if (inputBackwards.equals(input)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
