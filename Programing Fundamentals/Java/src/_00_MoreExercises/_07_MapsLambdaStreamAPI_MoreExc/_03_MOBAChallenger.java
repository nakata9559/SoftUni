package _00_MoreExercises._07_MapsLambdaStreamAPI_MoreExc;

import java.util.*;

public class _03_MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> challengers = new LinkedHashMap<>();

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("Season")
            && input[1].equals("end")) {
                break;
            }

            switch (input[1]) {
                case "->":
                    String player = input[0];
                    String position = input[2];
                    int skill = Integer.parseInt(input[4]);

                    if (!challengers.containsKey(player)) {
                        challengers.put(player, new LinkedHashMap<>());
                        challengers.get(player).put(position, skill);

                    } else {
                        if (!challengers.get(player).containsKey(position)) {
                            challengers.get(player).put(position, skill);

                        } else if (challengers.get(player).get(position) < skill) {
                            challengers.get(player).put(position, skill);
                        }
                    }

                    break;

                case "vs":
                    String playerOne = input[0];
                    String playerTwo = input[2];

                    if (challengers.containsKey(playerOne)
                            && challengers.containsKey(playerTwo)) {

                        List<String> equalPositions = new ArrayList<>(challengers.get(playerOne).keySet());
                        equalPositions.retainAll(challengers.get(playerTwo).keySet());

                        for (String equalPosition : equalPositions) {
                            if (challengers.get(playerOne).get(equalPosition) >
                                    challengers.get(playerTwo).get(equalPosition)) {

                                challengers.get(playerTwo).remove(equalPosition);

                            } else if (challengers.get(playerOne).get(equalPosition) <
                                    challengers.get(playerTwo).get(equalPosition)) {

                                challengers.get(playerOne).remove(equalPosition);
                            }
                        }
                    }
                    break;
            }
        }
        challengers.entrySet().removeIf(entry -> entry.getValue().isEmpty());

        Map<String, Map<String, Integer>> sortedChallengers = new LinkedHashMap<>();

        challengers.entrySet()
                .stream()
                .sorted((challenger1, challenger2) -> {
                    int totalPoints = Integer.compare(challenger2.getValue().values().stream().mapToInt(i -> i).sum(),
                            challenger1.getValue().values().stream().mapToInt(i -> i).sum());

                    if (totalPoints == 0) {
                        totalPoints = challenger1.getKey().compareTo(challenger2.getKey());
                    }
                    return totalPoints;

                }).forEach(entry -> {
                    System.out.printf("%s: %d skill%n",
                            entry.getKey(),
                            entry.getValue().values().stream().mapToInt(i -> i).sum());

                    entry.getValue()
                            .entrySet()
                            .stream()
                            .sorted((entry1, entry2) -> {
                                int points = Integer.compare(entry2.getValue(), entry1.getValue());
                                if (points == 0) {
                                    points = entry1.getKey().compareTo(entry2.getKey());
                                }
                                return points;

                            }).forEach(e -> {
                                System.out.printf("- %s <::> %d%n", e.getKey(), e.getValue());
                            });
                });
    }
}

