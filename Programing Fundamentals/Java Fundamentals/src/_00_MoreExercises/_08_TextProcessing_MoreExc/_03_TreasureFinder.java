package _00_MoreExercises._08_TextProcessing_MoreExc;

import java.util.Arrays;
import java.util.Scanner;

public class _03_TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] key = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        while (true) {
            String text = scanner.nextLine();
            if (text.equals("find")) {
                break;
            }

            StringBuilder decryptedText = new StringBuilder();

            int keyIndex = 0;

            for (int i = 0; i < text.length(); i++) {
                decryptedText.append((char)(text.charAt(i) - key[keyIndex]));

                keyIndex++;
                if (keyIndex >= key.length) {
                    keyIndex = 0;
                }
            }

            int typeFirstIndex = decryptedText.indexOf("&") + 1;
            int typeLastIndex = decryptedText.lastIndexOf("&");
            int coordinatesFirstIndex = decryptedText.indexOf("<") + 1;
            int coordinatesLastIndex = decryptedText.lastIndexOf(">");


            String type = decryptedText.substring(typeFirstIndex, typeLastIndex);
            String coordinates = decryptedText.substring(coordinatesFirstIndex, coordinatesLastIndex);

            System.out.println("Found " + type + " at " + coordinates);
        }
    }
}
