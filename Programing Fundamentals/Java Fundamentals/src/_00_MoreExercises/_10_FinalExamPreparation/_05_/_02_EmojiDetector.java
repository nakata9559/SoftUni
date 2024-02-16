package _00_MoreExercises._10_FinalExamPreparation._05_;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("(:{2}|\\*{2})([A-Z][a-z]{2,})\\1");
        Matcher matcher = pattern.matcher(text);

        int coolThreshold = 1;
        for (char eachChar : text.toCharArray()) {
            if (Character.isDigit(eachChar)) {
                coolThreshold *= Character.getNumericValue(eachChar);
            }
        }

        int numOfEmojis = 0;
        List<String> coolEmojis = new ArrayList<>();

        while (matcher.find()) {
            numOfEmojis++;
            int sumOfEachValue = 0;

            for (char eachChar : matcher.group(2).toCharArray()) {
                sumOfEachValue += eachChar;
            }

            if (sumOfEachValue > coolThreshold) {
                coolEmojis.add(matcher.group());
            }
        }

        System.out.printf("Cool threshold: %d\n" +
                "%d emojis found in the text. The cool ones are:\n" +
                "%s\n",
                coolThreshold,
                numOfEmojis,
                String.join("\n", coolEmojis));
    }
}
