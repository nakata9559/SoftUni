package _18_RegularExpressions_Exc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01_Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile(">>(?<name>[A-Za-z]+)<<(?<price>\\d+\\.?\\d*)!(?<quantity>\\d+)");
        Matcher matcher;
        double sum = 0;
        List<String> furnitureBought = new ArrayList<>();
        furnitureBought.add("Bought furniture:");

        while(true) {
            String input = scanner.nextLine();
            if (input.equals("Purchase")) {
                break;
            }

            matcher = pattern.matcher(input);

            while (matcher.find()) {
                furnitureBought.add(matcher.group("name"));
                sum += Double.parseDouble(matcher.group("price")) * Double.parseDouble(matcher.group("quantity"));
            }
        }
        System.out.printf("%s%n" +
                        "Total money spend: %.2f",
                String.join("\n", furnitureBought),
                sum);
    }
}
