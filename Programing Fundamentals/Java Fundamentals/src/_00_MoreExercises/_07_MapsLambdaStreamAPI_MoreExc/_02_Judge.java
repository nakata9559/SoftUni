package _00_MoreExercises._07_MapsLambdaStreamAPI_MoreExc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _02_Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> contestList = new LinkedHashMap<>();

        while (true){
            String[] input = scanner.nextLine().split(" -> ");

            if (input[0].equals("no more time")) {
                break;
            }

            String participant = input[0];
            String contest = input[1];
            int points = Integer.parseInt(input[2]);

            if (!contestList.containsKey(contest)) {
                contestList.put(contest, new LinkedHashMap<>());
                contestList.get(contest).put(participant, points);

            } else {
                if (contestList.get(contest).containsKey(participant)
                && contestList.get(contest).get(participant) < points) {
                    contestList.get(contest).put(participant, points);

                } else if (!contestList.get(contest).containsKey(participant)) {
                    contestList.get(contest).put(participant, points);
                }
            }
        }

        int position;

        for (Map.Entry<String, Map<String, Integer>> entry1 : contestList.entrySet()) {
            System.out.printf("%s: %d participants%n",
                    entry1.getKey(),
                    entry1.getValue().size());

            position = 0;
            Map<String, Integer> sortedPoints = new LinkedHashMap<>();

            entry1.getValue()
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                            .thenComparing(Map.Entry.comparingByKey()))
                    .forEachOrdered(x -> sortedPoints.put(x.getKey(), x.getValue()));

            for (Map.Entry<String, Integer> entry2 : sortedPoints.entrySet()) {
                position++;

                System.out.printf("%d. %s <::> %d%n",
                        position,
                        entry2.getKey(),
                        entry2.getValue());
            }
        }

        Map<String, Integer> totalPoints = new LinkedHashMap<>();

        contestList.forEach((key1, value1) -> value1.forEach((key2, value2) -> {
            totalPoints.putIfAbsent(key2, 0);
            totalPoints.put(key2, totalPoints.get(key2) + value2);
        }));

        Map<String, Integer> sortedTotalPoints = new LinkedHashMap<>();

        totalPoints.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEachOrdered(x -> sortedTotalPoints.put(x.getKey(), x.getValue()));


        position = 0;

        System.out.println("Individual standings:");

        for (Map.Entry<String, Integer> entry : sortedTotalPoints.entrySet()) {
            position++;
            System.out.printf("%d. %s -> %d%n",
                    position,
                    entry.getKey(),
                    entry.getValue());

        }
    }
}
