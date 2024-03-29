package _04_Encapsulation_Exc._03_ShoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] peopleData = scanner.nextLine().split(";");
        String[] productsData = scanner.nextLine().split(";");
        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new HashMap<>();

        for (String eachPersonData : peopleData) {
            String name = eachPersonData.split("=")[0];
            double money = Double.parseDouble(eachPersonData.split("=")[1]);

            try {
                Person person = new Person(name, money);
                people.put(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        for (String eachProductData : productsData) {
            String name = eachProductData.split("=")[0];
            double cost = Double.parseDouble(eachProductData.split("=")[1]);

            try {
                Product product = new Product(name, cost);
                products.put(name, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        if (people.isEmpty()) {
            return;
        }

        while (true) {
            String[] tokens = scanner.nextLine().split("\\s+");
            if ("END".equals(tokens[0])) {
                break;
            }

            String personName = tokens[0];
            String productName = tokens[1];

            Person person = people.get(personName);
            Product product = products.get(productName);

            try {
                person.buyProduct(product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        people.forEach((k, v) -> {
            System.out.println(v);
        });
    }
}
