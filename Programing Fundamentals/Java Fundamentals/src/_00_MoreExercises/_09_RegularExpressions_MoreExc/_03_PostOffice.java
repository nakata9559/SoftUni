package _00_MoreExercises._09_RegularExpressions_MoreExc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] message = scanner.nextLine().split("\\|");
        String[] words = message[2].split(" ");

        Pattern patternFirstPart = Pattern.compile("([#$%&*])(?<capitalLetters>[A-Z]+)\\1");
        Pattern patternSecondPart = Pattern.compile("(?<startingLetterCode>\\d{2}):(?<length>\\d{2})");

        Matcher matcherFirstPart = patternFirstPart.matcher(message[0]);
        Matcher matcherSecondPart = patternSecondPart.matcher(message[1]);

        char[] validLetters = new char[0];

        if (matcherFirstPart.find()) {
            validLetters = matcherFirstPart.group("capitalLetters").toCharArray();
        }

        List<Integer> startingCode = new ArrayList<>();
        List<Integer> length = new ArrayList<>();

        while (matcherSecondPart.find()) {
            if (!startingCode.contains(Integer.parseInt(matcherSecondPart.group("startingLetterCode")))) {
                startingCode.add(Integer.parseInt(matcherSecondPart.group("startingLetterCode")));
                length.add(1 + Integer.parseInt(matcherSecondPart.group("length")));
            }
        }

        for (char eachChar: validLetters) {
            for (String word : words) {
                for (int i = 0; i < startingCode.size(); i++) {
                    if (eachChar == startingCode.get(i)
                            && eachChar == word.charAt(0)
                            && word.length() == length.get(i)) {
                        System.out.println(word);
                    }
                }
            }
        }
    }
}
