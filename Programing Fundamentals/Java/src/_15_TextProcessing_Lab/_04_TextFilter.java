package _15_TextProcessing_Lab;

import java.util.Scanner;

public class _04_TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String bannedWord : bannedWords) {
            StringBuilder replaceWord = new StringBuilder();

            replaceWord.append("*".repeat(bannedWord.length()));

            while (text.contains(bannedWord)) {
                text = text.replace(bannedWord, replaceWord);
            }
        }

        System.out.println(text);
    }
}
