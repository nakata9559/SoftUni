package _18_RegularExpressions_Exc;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _06_ValidPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());

        Pattern pattern = Pattern.compile("_\\.+(?<characters>[A-Z][A-Za-z0-9]{4,}[A-Z])_\\.+");

        for (int i = 0; i < numberOfLines; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (!matcher.find()) {
                System.out.println("Invalid pass!");

            } else {
                StringBuilder digits = new StringBuilder();

                for (char eachChar : matcher.group("characters").toCharArray()) {
                    if (Character.isDigit(eachChar)) {
                        digits.append(eachChar);
                    }
                }

                if (digits.length() < 1) {
                    System.out.println("Group: default");

                } else {
                    System.out.printf("Group: %s%n", digits);
                }
            }
        }
    }
}
