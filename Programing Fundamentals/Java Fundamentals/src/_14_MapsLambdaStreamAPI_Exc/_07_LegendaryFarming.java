package _14_MapsLambdaStreamAPI_Exc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _07_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> loot = new LinkedHashMap<>();
        loot.put("shards", 0);
        loot.put("fragments", 0);
        loot.put("motes", 0);

        while(true) {
            int materialsQuantity = Integer.parseInt(scanner.next());
            String materials = scanner.next().toLowerCase();

            if (!loot.containsKey(materials)) {
                loot.put(materials, materialsQuantity);
            } else {
                loot.put(materials, loot.get(materials) + materialsQuantity);
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

        for (Map.Entry<String, Integer> entry : loot.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());

        }
    }
}
