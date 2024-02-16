package _06_SetsAndMapsAdvanced_Exc;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _09_PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Long> totalPopulation = new LinkedHashMap<>();
        Map<String, Map<String, Long>> cityData = new LinkedHashMap<>();

        String[] tokens = scanner.nextLine().split("\\|");

        while (!"report".equals(tokens[0])) {
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            totalPopulation.putIfAbsent(country, 0L);
            totalPopulation.put(country, totalPopulation.get(country) + population);

            cityData.putIfAbsent(country, new LinkedHashMap<>());
            cityData.get(country).put(city, population);

            tokens = scanner.nextLine().split("\\|");
        }

        totalPopulation.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry1 -> {
                    System.out.printf("%s (total population: %d)%n", entry1.getKey(), entry1.getValue());

                    cityData.get(entry1.getKey())
                            .entrySet()
                            .stream()
                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .forEach(entry2 -> System.out.printf("=>%s: %d%n", entry2.getKey(), entry2.getValue()));
                });
    }
}
