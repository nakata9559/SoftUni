package _00_MoreExercises._10_FinalExamPreparation._02_;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _03_PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfPlants = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> plantRarity = new LinkedHashMap<>();
        Map<String, Double> plantRating = new LinkedHashMap<>();

        for (int i = 0; i < numOfPlants; i++) {
            String[] input = scanner.nextLine().split("<->");
            plantRarity.put(input[0], Integer.parseInt(input[1]));
            plantRating.put(input[0], 0.0);
        }

        while (true) {
            String[] input = scanner.nextLine().split(": ");
            if (input[0].equals("Exhibition")) {
                break;
            }

            if (!plantRarity.containsKey(input[1].split(" - ")[0])) {
                System.out.println("error");
                continue;
            }

            switch (input[0]) {
                case "Rate":
                    String[] rate = input[1].split(" - ");
                    if (plantRating.get(rate[0]) == 0) {
                        plantRating.replace(rate[0], Double.parseDouble(rate[1]));
                    } else {
                        plantRating.replace(rate[0], (plantRating.get(rate[0]) + Double.parseDouble(rate[1])) / 2);
                    }
                    break;

                case "Update":
                    String[] update = input[1].split(" - ");
                    plantRarity.put(update[0], Integer.parseInt(update[1]));
                    break;

                case "Reset":
                    plantRating.replace(input[1], 0.0);
                    break;
            }
        }

        System.out.println("Plants for the exhibition: ");
        plantRarity.forEach((name, value) -> {
            int rarity = value;
            double rating = plantRating.get(name);

            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",
                    name,
                    rarity,
                    rating);
        });
    }
}
