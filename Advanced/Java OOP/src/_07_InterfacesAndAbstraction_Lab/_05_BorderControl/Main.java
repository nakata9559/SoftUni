package _07_InterfacesAndAbstraction_Lab._05_BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> list = new ArrayList<>();

        String[] tokens = scanner.nextLine().split("\\s+");

        while (!"End".equals(tokens[0])) {

            if (tokens.length == 2) {
                list.add(new Robot(tokens[0], tokens[1]));
            } else {
                list.add(new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
            }

            tokens = scanner.nextLine().split("\\s+");
        }

        String fakeId = scanner.nextLine();

        list.stream()
                .filter(e -> e.getId().endsWith(fakeId))
                .forEach(e -> System.out.println(e.getId()));
    }
}
