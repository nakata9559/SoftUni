package _05_SetsAndMapsAdvanced_Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _06_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> stores = new TreeMap<>();

        String[] tokens = scanner.nextLine().split(",\\s+");

        while (!"Revision".equals(tokens[0])) {
            String storeName = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            stores.putIfAbsent(storeName, new LinkedHashMap<>());
            stores.get(storeName).put(product, price);

            tokens = scanner.nextLine().split(",\\s+");
        }

        stores.forEach((k1, v1) -> {
            System.out.printf("%s->%n", k1);

            v1.forEach((k2, v2) -> {
                System.out.printf("_04_Encapsulation_Exc._03_ShoppingSpree.Product: %s, Price: %.1f%n", k2, v2);
            });
        });
    }
}
