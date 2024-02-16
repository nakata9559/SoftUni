package _06_SetsAndMapsAdvanced_Exc;

import java.util.*;

public class _07_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<Integer, List<Integer>>> playersHands = new LinkedHashMap<>();

        String[] tokens = scanner.nextLine().split(":\\s+");

        while (!"JOKER".equals(tokens[0])) {
            String name = tokens[0];
            String[] cards = tokens[1].split(",\\s+");

            playersHands.putIfAbsent(name, new LinkedHashMap<>());

            for (String card : cards) {
                String cardPower = "0";
                String cardType = "0";
                if (card.length() == 2) {
                    cardPower = card.substring(0, 1);
                    cardType = card.substring(1);
                } else if (card.length() == 3) {
                    cardPower = card.substring(0, 2);
                    cardType = card.substring(2);

                }
                switch (cardPower) {
                    case "J":
                        cardPower = "11";
                        break;
                    case "Q":
                        cardPower = "12";
                        break;
                    case "K":
                        cardPower = "13";
                        break;
                    case "A":
                        cardPower = "14";
                        break;
                }

                switch (cardType) {
                    case "S":
                        cardType = "4";
                        break;
                    case "H":
                        cardType = "3";
                        break;
                    case "D":
                        cardType = "2";
                        break;
                    case "C":
                        cardType = "1";
                        break;
                }

                playersHands.get(name).putIfAbsent(Integer.parseInt(cardPower), new ArrayList<>());

                if (!playersHands.get(name).containsKey(Integer.parseInt(cardPower))) {
                    playersHands.get(name).get(Integer.parseInt(cardPower)).add(Integer.parseInt(cardType));
                } else {
                    if (!playersHands.get(name).get(Integer.parseInt(cardPower)).contains(Integer.parseInt(cardType))) {
                        playersHands.get(name).get(Integer.parseInt(cardPower)).add(Integer.parseInt(cardType));
                    }
                }
            }
            tokens = scanner.nextLine().split(":\\s+");
        }

        playersHands.forEach((k1, v1) -> {
            int points = 0;

            for (Map.Entry<Integer, List<Integer>> eachSet : v1.entrySet()) {
                for (int eachPoint : eachSet.getValue()) {
                    points += eachPoint * eachSet.getKey();
                }
            }

            System.out.printf("%s: %d%n", k1, points);
        });
    }
}
