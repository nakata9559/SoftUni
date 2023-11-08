package _00_MoreExercises._07_MapsLambdaStreamAPI_MoreExc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _01_Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contest = new LinkedHashMap<>();

        while (true) {
            String[] input = scanner.nextLine().split(":");
            if (input[0].equals("end of contests")) {
                break;
            }

            String name = input[0];
            String password = input[1];

            contest.put(name, password);
        }

        Map<String, Map<String, Integer>> rankings = new TreeMap<>();

        while(true) {
            String[] input = scanner.nextLine().split("=>");
            if (input[0].equals("end of submissions")) {
                break;
            }

            String submissionName = input[0];
            String submissionPassword = input[1];
            String participantName = input[2];
            int points = Integer.parseInt(input[3]);

            if (!contest.containsKey(submissionName) || !contest.get(submissionName).contains(submissionPassword)) {
                continue;
            }

            rankings.putIfAbsent(participantName, new LinkedHashMap<>());
            rankings.get(participantName).putIfAbsent(submissionName, points);
            if (rankings.get(participantName).get(submissionName) < points) {
                rankings.get(participantName).put(submissionName, points);
            }
        }

        String bestCandidate = "";
        int totalPoints = 0;

        for (Map.Entry<String, Map<String, Integer>> entry1 : rankings.entrySet()) {
            int currentPoints = 0;

            for (Map.Entry<String, Integer> entry2 : entry1.getValue().entrySet()) {
                currentPoints += entry2.getValue();
            }

            if (totalPoints < currentPoints) {
                bestCandidate = entry1.getKey();
                totalPoints = currentPoints;
            }
        }

        System.out.printf("Best candidate is %s with total %d points.%n",
                bestCandidate,
                totalPoints);

        System.out.println("Ranking: ");

        rankings.forEach((key1, value1) -> {
            System.out.println(key1);

            /*Map<String, Integer> sortedMap =
                    value1.entrySet()
                            .stream()
                            .sorted(comparingByValue())
                            .collect(Collectors.toMap(
                                    Map.Entry::getKey,
                                    Map.Entry::getValue,
                                    (e1, e2) -> e2, LinkedHashMap::new))
                            .reversed();*/

            Map<String, Integer> sortedMap = new LinkedHashMap<>();

            value1.entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

            sortedMap.forEach((key2, value2) -> {
                System.out.printf("#  %s -> %d%n", key2, value2);
            });
        });
    }
}
