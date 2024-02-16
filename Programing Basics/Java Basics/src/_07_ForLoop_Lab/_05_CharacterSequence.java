package _07_ForLoop_Lab;

import java.util.Scanner;

public class _05_CharacterSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String words = scanner.nextLine();

        for (int letterNumber = 0; letterNumber < words.length(); letterNumber++) {
            System.out.println(words.charAt(letterNumber));
        }
    }
}
