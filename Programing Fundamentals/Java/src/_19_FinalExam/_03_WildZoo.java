package _19_FinalExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _03_WildZoo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> neededFood = new LinkedHashMap<>();
        Map<String, String> areaName = new LinkedHashMap<>();

        while (true) {
            String[] command = scanner.nextLine().split(": ");
            if (command[0].equals("EndDay")) {
                break;
            }

            String name = command[1].split("-")[0];
            int food = Integer.parseInt(command[1].split("-")[1]);

            switch (command[0]) {
                case "Add":
                    String area = command[1].split("-")[2];
                    if (!neededFood.containsKey(name)) {
                        neededFood.put(name, food);
                        areaName.put(name, area);

                    } else {
                        neededFood.replace(name, neededFood.get(name), neededFood.get(name) + food);
                    }
                    break;

                case "Feed":
                    if (neededFood.containsKey(name)) {
                        neededFood.replace(name, neededFood.get(name), neededFood.get(name) - food);

                        if (neededFood.get(name) <= 0) {
                            neededFood.remove(name);
                            areaName.remove(name);
                            System.out.printf("%s was successfully fed\n",
                                    name);
                        }
                    }
                    break;
            }
        }
        Map<String, Integer> areaWithHungryAnimals = new LinkedHashMap<>();

        System.out.println("Animals:");
        neededFood.forEach((key, value) -> {
            System.out.printf(" %s -> %dg\n",
                    key,
                    value);

            if (!areaWithHungryAnimals.containsKey(areaName.get(key))) {
                areaWithHungryAnimals.put(areaName.get(key), 1);
            } else {
                areaWithHungryAnimals.replace(areaName.get(key),
                        areaWithHungryAnimals.get(areaName.get(key)),
                        areaWithHungryAnimals.get(areaName.get(key)) + 1);
            }
        });

        System.out.println("Areas with hungry animals:");
        areaWithHungryAnimals.forEach((key, value) -> {

            System.out.printf(" %s: %d\n",
                    key,
                    value);
        });
    }
}
