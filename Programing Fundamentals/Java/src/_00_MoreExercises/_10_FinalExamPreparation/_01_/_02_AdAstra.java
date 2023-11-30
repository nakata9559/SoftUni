package _00_MoreExercises._10_FinalExamPreparation._01_;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String productsData = scanner.nextLine();

        Pattern pattern = Pattern.compile("([#|])(?<itemName>[A-Z a-z]+)\\1(?<expDate>\\d{2}/\\d{2}/\\d{2})\\1(?<calories>\\d+)\\1");
        Matcher matcher = pattern.matcher(productsData);

        int totalCalories = 0;
        List<String> items = new ArrayList<>();

        while (matcher.find()) {
            totalCalories += Integer.parseInt(matcher.group("calories"));
            items.add(matcher.group("itemName"));
            items.add(matcher.group("expDate"));
            items.add(matcher.group("calories"));
        }

        System.out.printf("You have food to last you for: %d days!\n", totalCalories / 2000);

        for (int i = 0; i < items.size(); i+= 3) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %s\n",
                    items.get(i),
                    items.get(i + 1),
                    items.get(i + 2));
        }
    }
}
