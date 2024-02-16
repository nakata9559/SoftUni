package _06_SetsAndMapsAdvanced_Exc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _12_SrpskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> singersProfit = new LinkedHashMap<>();

        Pattern pattern = Pattern.compile("^(?<name>[A-Za-z0-9\\s]+)\\s@(?<city>[A-Za-z\\s]+)\\s(?<price>[0-9]+)\\s(?<tickets>[0-9]+)$");
        Matcher matcher;
        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            matcher = pattern.matcher(input);

            while (matcher.find()) {
                String name = matcher.group("name");
                String city = matcher.group("city");

                if (name.split("\\s").length > 3 || city.split("\\s").length > 3) {
                    continue;
                }

                int profit = Integer.parseInt(matcher.group("price")) * Integer.parseInt(matcher.group("tickets"));

                singersProfit.putIfAbsent(city, new LinkedHashMap<>());
                singersProfit.get(city).putIfAbsent(name, 0);
                singersProfit.get(city).put(name, singersProfit.get(city).get(name) + profit);
            }

            input = scanner.nextLine();
        }

        singersProfit.forEach((k1, v1) -> {
            System.out.println(k1);

            v1.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(entry -> System.out.printf("#  %s -> %d\n",
                            entry.getKey(),
                            entry.getValue()));
        });
    }
}
