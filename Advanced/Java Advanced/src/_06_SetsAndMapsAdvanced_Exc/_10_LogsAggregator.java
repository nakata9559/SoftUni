package _06_SetsAndMapsAdvanced_Exc;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class _10_LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> userData = new TreeMap<>();
        Map<String, Integer> totalDuration = new HashMap<>();
        int numOfSessions = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfSessions; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[1];
            String address = tokens[0];
            int duration = Integer.parseInt(tokens[2]);

            userData.putIfAbsent(name, new ArrayList<>());
            if (!userData.get(name).contains(address)) {
                userData.get(name).add(address);
            }

            totalDuration.putIfAbsent(name, 0);
            totalDuration.put(name, totalDuration.get(name) + duration);
        }

        userData.forEach((k1, v1) -> {
            Collections.sort(v1);
            System.out.printf("%s: %d [", k1, totalDuration.get(k1));
            AtomicInteger index = new AtomicInteger();
            v1.forEach(e -> {
                if (index.getAndIncrement() < v1.size() - 1) {
                    System.out.printf("%s, ", e);
                } else {
                    System.out.printf("%s]\n", e);
                }
            });
        });
    }
}
