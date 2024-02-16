package _06_SetsAndMapsAdvanced_Exc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contacts = new HashMap<>();

        String[] tokens = scanner.nextLine().split("-");

        while (!"search".equals(tokens[0])) {
            contacts.putIfAbsent(tokens[0], "");
            contacts.put(tokens[0], tokens[1]);

            tokens = scanner.nextLine().split("-");
        }

        tokens = scanner.nextLine().split("-");

        while (!"stop".equals(tokens[0])) {
            if (contacts.containsKey(tokens[0])) {
                System.out.printf("%s -> %s%n", tokens[0], contacts.get(tokens[0]));
            } else {
                System.out.printf("Contact %s does not exist.%n", tokens[0]);
            }

            tokens = scanner.nextLine().split("-");
        }
    }
}
