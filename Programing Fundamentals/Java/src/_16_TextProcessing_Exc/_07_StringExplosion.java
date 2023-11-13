package _16_TextProcessing_Exc;

import java.util.Scanner;

public class _07_StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());

        int explosionPower = 0;

        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i - 1) == '>'
             && text.charAt(i) != '>'
            && text.charAt(i) >= '0'
            && text.charAt(i) <= '9') {
                explosionPower += Integer.parseInt(String.valueOf(text.charAt(i)));
            }

            if (explosionPower > 0 && text.charAt(i) != '>') {
                text.replace(i, i + 1, "");
                explosionPower--;
                i--;
            }
        }
        System.out.println(text);
    }
}
