package _05_SetsAndMapsAdvanced_Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _04_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> realNums = new LinkedHashMap<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .forEach(v -> {
                    realNums.putIfAbsent(v, 0);
                    realNums.put(v, realNums.get(v) + 1);
                });

        realNums.forEach((k, v) -> {
            System.out.printf("%.1f -> %d%n", k, v);
        });
    }
}
