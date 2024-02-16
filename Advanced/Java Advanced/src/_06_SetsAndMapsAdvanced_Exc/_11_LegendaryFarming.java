package _06_SetsAndMapsAdvanced_Exc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class _11_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> loot = new TreeMap<>();
        Map<String, Integer> junk = new TreeMap<>();
        loot.put("shards", 0);
        loot.put("fragments", 0);
        loot.put("motes", 0);

        while(true) {
            int materialsQuantity = Integer.parseInt(scanner.next());
            String materials = scanner.next().toLowerCase();

            switch (materials) {
                case "shards":
                case "fragments":
                case "motes":
                    if (!loot.containsKey(materials)) {
                        loot.put(materials, materialsQuantity);
                    } else {
                        loot.put(materials, loot.get(materials) + materialsQuantity);
                    }
                    break;
                default:
                    if (!junk.containsKey(materials)) {
                        junk.put(materials, materialsQuantity);
                    } else {
                        junk.put(materials, junk.get(materials) + materialsQuantity);
                    }
                    break;
            }

            if (materials.equals("shards")
                    || materials.equals("fragments")
                    || materials.equals("motes")) {

                if (loot.get(materials) >= 250) {

                    switch (materials) {
                        case "shards":
                            System.out.printf("Shadowmourne obtained!%n");
                            loot.put(materials, loot.get(materials) - 250);
                            break;
                        case "fragments":
                            System.out.printf("Valanyr obtained!%n");
                            loot.put(materials, loot.get(materials) - 250);
                            break;
                        case "motes":
                            System.out.printf("Dragonwrath obtained!%n");
                            loot.put(materials, loot.get(materials) - 250);
                            break;
                    }
                    break;
                }
            }
        }

        Map<String, Integer> sorted = loot.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, Integer> entry : junk.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }
}
