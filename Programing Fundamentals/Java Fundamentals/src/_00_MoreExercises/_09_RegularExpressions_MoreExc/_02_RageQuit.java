package _00_MoreExercises._09_RegularExpressions_MoreExc;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().toUpperCase();

        String regex = "(?<string>[\\D]*)(?<count>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        StringBuilder outputText = new StringBuilder();

        while (matcher.find()) {
            int count = Integer.parseInt(matcher.group("count"));
            String word = matcher.group("string");
            outputText.append(String.valueOf(word).repeat(Math.max(0, count)));
        }

        System.out.printf("Unique symbols used: %d%n", outputText.chars().distinct().count());
        System.out.println(outputText);
    }
}
