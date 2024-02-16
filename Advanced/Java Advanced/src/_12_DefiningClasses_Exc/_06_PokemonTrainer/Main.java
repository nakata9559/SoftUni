package _12_DefiningClasses_Exc._06_PokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Trainer> trainers = new ArrayList<>();

        String tokens = scanner.nextLine();

        while (!"Tournament".equals(tokens)) {
            String name = tokens.split("\\s+")[0];
            Pokemon pokemon = new Pokemon(tokens.split("\\s+")[1],
                    tokens.split("\\s+")[2],
                    Integer.parseInt(tokens.split("\\s+")[3]));

            if (trainers.isEmpty()) {
                Trainer trainer = new Trainer(name, pokemon);
                trainers.add(trainer);

            } else {
                if (exists(trainers, name)) {
                    trainers.forEach(e -> {
                        if (e.getName().equals(name)) {
                            e.addPokemons(pokemon);
                        }
                    });
                } else {
                    Trainer trainer = new Trainer(name, pokemon);
                    trainers.add(trainer);
                }
            }

            tokens = scanner.nextLine();
        }

        tokens = scanner.nextLine();

        while (!"End".equals(tokens)) {
            String element = tokens;
            trainers.forEach(e -> e.checkElement(element));

            tokens = scanner.nextLine();
        }

        trainers.stream()
                .sorted((e1, e2) -> Integer.compare(e2.getBadges(), e1.getBadges()))
                .forEach(System.out::println);
    }

    public static boolean exists(List<Trainer> trainers, String name) {
        for (Trainer trainer : trainers) {
            if (trainer.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
