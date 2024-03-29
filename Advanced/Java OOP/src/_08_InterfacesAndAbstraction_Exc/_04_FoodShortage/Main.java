package _08_InterfacesAndAbstraction_Exc._04_FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Buyer> list = new ArrayList<>();

        int numOfPeople = Integer.parseInt(scanner.nextLine());

        while (numOfPeople-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            if (tokens.length == 3) {
                String group = tokens[2];
                list.add(new Rebel(name, age, group));
            } else {
                String id = tokens[2];
                String birthDate = tokens[3];
                list.add(new Citizen(name,age, id, birthDate));
            }
        }

        String command = scanner.nextLine();

        while (!"End".equals(command)) {
            String name = command;

            list.stream()
                    .filter(e -> e.getName().equals(name))
                    .forEach(Buyer::buyFood);

            command = scanner.nextLine();
        }

        System.out.println(list.stream()
                .mapToInt(Buyer::getFood)
                .sum());
    }
}
