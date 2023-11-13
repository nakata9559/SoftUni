package _00_MoreExercises._08_TextProcessing_MoreExc;

import java.util.Scanner;

public class _02_AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstChar = scanner.nextLine();
        String lastChar = scanner.nextLine();
        String text = scanner.nextLine();

        int sum = 0;

        for (int i = 0; i < text.length(); i++) {
            if (firstChar.charAt(0) < text.charAt(i)
                    && lastChar.charAt(0) > text.charAt(i)) {
                sum += text.charAt(i);
            }
        }

        System.out.println(sum);
    }
}
