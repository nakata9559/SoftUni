package _08_InterfacesAndAbstraction_Exc._03_BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> list = new ArrayList<>();

        String command = scanner.nextLine();

        while (!"End".equals(command)) {
            String type = command.split("\\s+")[0];

            switch (type){
                case "Citizen":
                    Citizen citizen = new Citizen(command.split("\\s+")[1],
                            Integer.parseInt(command.split("\\s+")[2]),
                            command.split("\\s+")[3],
                            command.split("\\s+")[4]);

                    list.add(citizen);
                    break;

                case "Pet":
                    Pet pet = new Pet(command.split("\\s+")[1],
                            command.split("\\s+")[2]);

                    list.add(pet);
                    break;
            }

            command = scanner.nextLine();
        }

        String year = scanner.nextLine();

        list.stream()
                .filter(e -> e.getBirthDate().endsWith(year))
                .forEach(e -> System.out.println(e.getBirthDate()));
    }
}
