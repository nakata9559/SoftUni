package _05_SetsAndMapsAdvanced_Lab;

import java.util.*;
import java.util.stream.Collectors;

public class _07_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfLines = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> data = new LinkedHashMap<>();

        for (int i = 0; i < numOfLines; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            data.putIfAbsent(continent, new LinkedHashMap<>());
            data.get(continent).putIfAbsent(country, new ArrayList<>());
            data.get(continent).get(country).add(city);
        }

        data.forEach((k1, v1) -> {
            System.out.printf("%s:%n", k1);

            v1.forEach((k2, v2) -> {
                System.out.printf("  %s -> %s%n",
                        k2,
                        String.join(", ", v2.stream()
                                .map(String::valueOf)
                                .collect(Collectors.toList())));
            });
        });
    }
}
