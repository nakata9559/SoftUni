package _06_SetsAndMapsAdvanced_Exc;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> usernames = new LinkedHashSet<>();

        int numOfLines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfLines; i++) {
            usernames.add(scanner.nextLine());
        }

        usernames.forEach(System.out::println);
    }
}
