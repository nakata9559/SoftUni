package _16_TextProcessing_Exc;

import java.util.Scanner;

public class _01_ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] usernames = scanner.nextLine().split(", ");

        for (String username : usernames) {
            String check = username.replaceAll("\\w+|\\d+|-+|_+", "");

            if (check.isEmpty()
                    && username.length() >= 3
                    && username.length() <= 16) {
                System.out.println(username);
            }
        }
    }
}
