package _02_WorkingWithAbstraction_Exc._06_GreedyTimes;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long bagCapacity = Long.parseLong(scanner.nextLine());
        Bag bag = new Bag(bagCapacity);

        Pattern pattern = Pattern.compile("(?<product>[A-Za-z]+)\\s+(?<quantity>[0-9]+)");
        Matcher matcher = pattern.matcher(scanner.nextLine());

        while (matcher.find()) {
            String product = matcher.group("product");
            long quantity = Long.parseLong(matcher.group("quantity"));
            addItem(product, quantity, bag);
        }

        System.out.println(bag);
    }

    public static void addItem(String product, long quantity, Bag bag) {
        if (product.length() == 3) {
            bag.addCash(product, quantity);
        } else if (product.equalsIgnoreCase("gold")) {
            bag.addGold(product, quantity);
        } else if (product.toLowerCase().endsWith("gem")) {
            bag.addGems(product, quantity);
        }
    }
}