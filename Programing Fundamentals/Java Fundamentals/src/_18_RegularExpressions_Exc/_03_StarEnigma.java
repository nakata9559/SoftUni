package _18_RegularExpressions_Exc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> decryptedMessages = new ArrayList<>();

        int numberOfPlanets = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfPlanets; i++) {
            String encryptedMessage = scanner.nextLine();
            int countLetters = 0;

            for (int j = 0; j < encryptedMessage.length(); j++) {
                if (encryptedMessage.charAt(j) == 'S'
                        || encryptedMessage.charAt(j) == 's'
                        || encryptedMessage.charAt(j) == 'T'
                        || encryptedMessage.charAt(j) == 't'
                        || encryptedMessage.charAt(j) == 'A'
                        || encryptedMessage.charAt(j) == 'a'
                        || encryptedMessage.charAt(j) == 'R'
                        || encryptedMessage.charAt(j) == 'r') {
                    countLetters++;
                }
            }

            StringBuilder decryptedMessage = new StringBuilder();

            for (int j = 0; j < encryptedMessage.length(); j++) {
                decryptedMessage.append((char)(encryptedMessage.charAt(j) - countLetters));
            }

            decryptedMessages.add(decryptedMessage.toString());
        }

        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        Pattern pattern = Pattern.compile("@(?<name>[A-Za-z]+)[^@\\-!:>]*:(?<population>\\d+)[^@\\-!:>]*!(?<attackType>[AD])![^@\\-!:>]*->(?<soldierCount>\\d+)");
        Matcher matcher;

        for (String message : decryptedMessages) {
            matcher = pattern.matcher(message);

            while (matcher.find()) {
                if (matcher.group("attackType").equals("A")) {
                    attackedPlanets.add(matcher.group("name"));

                } else {
                    destroyedPlanets.add(matcher.group("name"));
                }
            }
        }

        Collections.sort(attackedPlanets);
        Collections.sort(destroyedPlanets);

        if (attackedPlanets.isEmpty()) {
            System.out.println("Attacked planets: 0");
        } else {
            System.out.printf("Attacked planets: %d%n" +
                    "-> %s%n",
                    attackedPlanets.size(),
                    String.join("\n-> ", attackedPlanets));
        }

        if (destroyedPlanets.isEmpty()) {
            System.out.println("Destroyed planets: 0");
        } else {
            System.out.printf("Destroyed planets: %d%n" +
                            "-> %s%n",
                    destroyedPlanets.size(),
                    String.join("\n-> ", destroyedPlanets));
        }
    }
}
