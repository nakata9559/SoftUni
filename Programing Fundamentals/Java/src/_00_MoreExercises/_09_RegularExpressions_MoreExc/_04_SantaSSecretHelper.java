package _00_MoreExercises._09_RegularExpressions_MoreExc;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _04_SantaSSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("@(?<name>[A-Za-z]+)[^@\\-!:>]*!(?<behavior>[GN])!");

        while (true){
            String message = scanner.nextLine();
            if (message.equals("end")) {
                break;
            }

            StringBuilder decryptedMessage = new StringBuilder();

            for (char eachChar : message.toCharArray()) {
                decryptedMessage.append((char)(eachChar - key));
            }

            Matcher matcher = pattern.matcher(decryptedMessage);

            while (matcher.find()) {
                if (matcher.group("behavior").equals("G")) {
                    System.out.println(matcher.group("name"));
                }
            }
        }
    }
}
