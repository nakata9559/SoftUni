package _14_MapsLambdaStreamAPI_Exc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _03_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Double> prices = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> quantities = new LinkedHashMap<>();

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            String product = input[0];

            if (product.equals("buy")) {
                break;
            }

            double price = Double.parseDouble(input[1]);
            int quantity = Integer.parseInt(input[2]);

            prices.put(product, price);

            if (!quantities.containsKey(product)) {
                quantities.put(product, quantity);
            } else {
                quantities.put(product,
                        quantities.get(product) + quantity);
            }
        }

        for (Map.Entry<String, Double> entry1 : prices.entrySet()) {
            int quantity = 0;
            for (Map.Entry<String, Integer> entry2 : quantities.entrySet()) {
                if (entry1.getKey().equals(entry2.getKey())) {
                    quantity += (entry2.getValue());
                }
            }

            System.out.printf("%s -> %.2f%n",
                    entry1.getKey(),
                    entry1.getValue() * quantity);
        }
    }
}
