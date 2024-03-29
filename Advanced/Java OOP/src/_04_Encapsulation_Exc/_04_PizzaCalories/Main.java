package _04_Encapsulation_Exc._04_PizzaCalories;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Pattern pattern = Pattern.compile("(?<pizza>Pizza)\\s(?<name>.*)\\s(?<numOfToppings>[0-9]+)");
            Matcher matcher = pattern.matcher(scanner.nextLine());

            String[] tokens = new String[3];
            while (matcher.find()){
                tokens[0] = matcher.group("pizza");
                tokens[1] = matcher.group("name");
                tokens[2] = matcher.group("numOfToppings");
            }

            Pizza pizza = new Pizza(tokens[1], Integer.parseInt(tokens[2]));

            tokens = scanner.nextLine().split(" ");
            pizza.setDough(new Dough(tokens[1], tokens[2], Double.parseDouble(tokens[3])));

            tokens = scanner.nextLine().split(" ");
            while (!"END".equals(tokens[0])) {
                pizza.addTopping(new Topping(tokens[1], Double.parseDouble(tokens[2])));
                tokens = scanner.nextLine().split(" ");
            }

            System.out.printf("%s - %.2f%n",
                    pizza.getName(),
                    pizza.getOverallCalories());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
