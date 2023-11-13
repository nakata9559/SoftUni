package _16_TextProcessing_Exc;

import java.util.Scanner;

public class _06_ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        StringBuilder text = new StringBuilder(scanner.nextLine());

        char previousLetter = text.charAt(0);

        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) == previousLetter) {
                text.replace(i, i + 1, "");
                i--;
            }
            previousLetter = text.charAt(i);
        }

        System.out.println(text);
    }
}
