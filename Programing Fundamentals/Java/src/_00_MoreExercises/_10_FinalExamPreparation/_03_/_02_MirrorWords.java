package _00_MoreExercises._10_FinalExamPreparation._03_;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("([#@])(?<leftPart>[A-Za-z]{3,})\\1\\1(?<rightPart>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(input);

        List<String> validPairs = new ArrayList<>();
        int pairsFound = 0;

        while (matcher.find()) {
            pairsFound++;
            StringBuilder left = new StringBuilder(matcher.group("leftPart"));
            StringBuilder right = new StringBuilder(matcher.group("rightPart"));

            if (left.reverse().compareTo(right) == 0) {
                validPairs.add(matcher.group("leftPart"));
                validPairs.add(matcher.group("rightPart"));
            }
        }
        if (pairsFound > 0) {
            System.out.printf("%d word pairs found!\n", pairsFound);
        } else {
            System.out.println("No word pairs found!");
        }

        if (!validPairs.isEmpty()) {
            System.out.println("The mirror words are:");
            for (int i = 0; i < validPairs.size(); i+=2) {
                if (i + 2 == validPairs.size()) {
                    System.out.printf("%s <=> %s", validPairs.get(i), validPairs.get(i + 1));
                } else {
                    System.out.printf("%s <=> %s, ", validPairs.get(i), validPairs.get(i + 1));
                }
            }
        } else {
            System.out.println("No mirror words!");
        }

        System.out.println();
    }
}
