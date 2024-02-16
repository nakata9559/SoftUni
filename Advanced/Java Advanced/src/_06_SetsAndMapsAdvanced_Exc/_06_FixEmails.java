package _06_SetsAndMapsAdvanced_Exc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _06_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> userData = new LinkedHashMap<>();

        while (true) {
            String name = scanner.nextLine();
            if ("stop".equals(name)) {
                break;
            }
            boolean validEmail = true;
            String email = scanner.nextLine();
            if (email.toLowerCase().contains(".us")
                    || email.toLowerCase().contains(".uk")
                    || email.toLowerCase().contains(".com")) {
                validEmail = false;
            }
            if (validEmail) {
                userData.put(name, email);
            }
        }

        userData.forEach((k, v) -> {
            System.out.printf("%s -> %s%n", k, v);
        });
    }
}
