package _08_Methods_Exc;

import java.util.Scanner;

public class _03_CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printChars(scanner.nextLine().charAt(0), scanner.nextLine().charAt(0));
    }

    public static void printChars(char char1, char char2) {
        for (int i = char1 + 1; i < char2; i++) {
            System.out.printf("%c ", (char) i);
        }

        for (int i = char2 + 1; i < char1; i++) {
            System.out.printf("%c ", (char) i);
        }
    }
}
