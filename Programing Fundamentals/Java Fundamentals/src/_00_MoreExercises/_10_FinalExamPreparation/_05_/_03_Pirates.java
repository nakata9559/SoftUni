package _00_MoreExercises._10_FinalExamPreparation._05_;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _03_Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> populationEachTown = new LinkedHashMap<>();
        Map<String, Integer> goldEachTown = new LinkedHashMap<>();

        while (true) {
            String[] command = scanner.nextLine().split("\\|\\|");
            if (command[0].equals("Sail")) {
                break;
            }

            String town = command[0];
            int population = Integer.parseInt(command[1]);
            int gold = Integer.parseInt(command[2]);

            if (!populationEachTown.containsKey(town)) {
                populationEachTown.put(town, population);
                goldEachTown.put(town, gold);

            } else {
                populationEachTown.replace(town,
                        populationEachTown.get(town),
                        populationEachTown.get(town) + population);

                goldEachTown.replace(town,
                        goldEachTown.get(town),
                        goldEachTown.get(town) + gold);
            }
        }

        while (true) {
            String[] command = scanner.nextLine().split("=>");
            if (command[0].equals("End")) {
                break;
            }

            String town = command[1];

            switch (command[0]) {
                case "Plunder":
                    int[] plundered = plunder(town,
                            populationEachTown.get(town),
                            goldEachTown.get(town),
                            Integer.parseInt(command[2]),
                            Integer.parseInt(command[3]));

                    int currentPopulation = plundered[0];
                    int currentGold = plundered[1];

                    if (currentPopulation <= 0 || currentGold <= 0) {
                        System.out.printf("%s has been wiped off the map!\n", town);
                        populationEachTown.remove(town);
                        goldEachTown.remove(town);

                    } else {
                        populationEachTown.replace(town,
                                populationEachTown.get(town),
                                currentPopulation);

                        goldEachTown.replace(town,
                                goldEachTown.get(town),
                                currentGold);
                    }

                    break;

                case "Prosper":
                    int goldIncrease = Integer.parseInt(command[2]);
                    goldEachTown.replace(town,
                            goldEachTown.get(town),
                            prosper(town,
                                    goldEachTown.get(town),
                                    goldIncrease));
                    break;
            }
        }

        if (!populationEachTown.isEmpty()) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:\n",
                    populationEachTown.size());

            populationEachTown.forEach((key, value) -> {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg\n",
                        key,
                        value,
                        goldEachTown.get(key));
            });

        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
    public static int[] plunder(String town, int currentPopulation, int currentGold, int peopleKilled, int goldPlundered) {
        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.\n",
                town,
                goldPlundered,
                peopleKilled);

        return new int[]{currentPopulation - peopleKilled, currentGold - goldPlundered};
    }

    public static int prosper(String town, int currentGold, int goldIncrease) {
        if (goldIncrease >= 0) {
            currentGold += goldIncrease;
            System.out.printf("%d gold added to the city treasury. %s now has %d gold.\n",
                    goldIncrease,
                    town,
                    currentGold);
        } else {
            System.out.println("Gold added cannot be a negative number!");
        }
        return currentGold;
    }
}
