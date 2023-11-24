package _18_RegularExpressions_Exc;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _04_NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] demons = scanner.nextLine().split("\\s*,\\s*");

        for (String demon : demons) {
            demon = demon.replaceAll(" ", "");
            int health = 0;
            String healthText = demon.replaceAll("[0-9+\\-*/.]", "");

            for (char eachChar: healthText.toCharArray()){
                health += eachChar;
            }

            double damage = 0;

            Pattern pattern = Pattern.compile("-?[0-9]+\\.?[0-9]*");
            Matcher matcher = pattern.matcher(demon);

            while (matcher.find()) {
                damage += Double.parseDouble(matcher.group());
            }

            for (char eachChar : demon.toCharArray()) {
                if (eachChar == '*') {
                    damage *= 2;

                } else if (eachChar == '/') {
                    damage /= 2;
                }
            }

            System.out.printf("%s - %d health, %.2f damage%n",
                    demon,
                    health,
                    damage);
        }
    }
}
