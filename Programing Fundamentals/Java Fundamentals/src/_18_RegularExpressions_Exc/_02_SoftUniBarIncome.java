package _18_RegularExpressions_Exc;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("%(?<name>[A-Z][a-z]+)%.*<(?<product>\\w+)>.*\\|(?<quantity>\\d+)\\|\\D*(?<price>\\d+\\.*\\d*)\\$");
        Matcher matcher;
        double totalIncome = 0;

        while (true){
            String input = scanner.nextLine();
            if (input.equals("end of shift")) {
                break;
            }

            matcher = pattern.matcher(input);

            while (matcher.find()) {
                System.out.printf("%s: %s - %.2f%n",
                        matcher.group("name"),
                        matcher.group("product"),
                        Double.parseDouble(matcher.group("quantity")) * Double.parseDouble(matcher.group("price")));

                totalIncome += Double.parseDouble(matcher.group("quantity")) * Double.parseDouble(matcher.group("price"));
            }
        }
        System.out.printf("Total income: %.2f%n", totalIncome);
    }
}
