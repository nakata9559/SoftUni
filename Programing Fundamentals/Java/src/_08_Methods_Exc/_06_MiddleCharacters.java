package _08_Methods_Exc;

import java.util.Scanner;

public class _06_MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        middleCharacters(scanner.nextLine());
    }

    public static void middleCharacters(String input) {
        if (input.length() % 2 == 0) {
            System.out.printf("%s%s%n", input.charAt(input.length() / 2 - 1), input.charAt(input.length() / 2));

        } else {
            System.out.printf("%s%n", input.charAt(input.length() / 2));
        }
    }
}
