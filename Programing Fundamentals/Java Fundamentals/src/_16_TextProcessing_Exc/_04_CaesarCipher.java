package _16_TextProcessing_Exc;

import java.util.Scanner;

public class _04_CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputText = scanner.nextLine();
        StringBuilder outputText = new StringBuilder();

        for (int i = 0; i < inputText.length(); i++) {
            int charAtIndex = inputText.charAt(i) + 3;
            outputText.append((char)charAtIndex);
        }

        System.out.println(outputText);
    }
}
