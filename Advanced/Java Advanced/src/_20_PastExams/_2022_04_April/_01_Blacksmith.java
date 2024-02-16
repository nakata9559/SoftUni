package _20_PastExams._2022_04_April;

import java.util.*;

public class _01_Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, String> swordTable = new HashMap<>();
        swordTable.put(70, "Gladius");
        swordTable.put(80, "Shamshir");
        swordTable.put(90, "Katana");
        swordTable.put(110, "Sabre");

        Deque<Integer> steelQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(steelQueue::offer);

        Deque<Integer> carbonStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(carbonStack::push);

        int totalForgedSwords = 0;
        Map<String, Integer> swordsForged = new TreeMap<>();

        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
            int steel = steelQueue.poll();
            int carbon = carbonStack.pop();

            if (swordTable.containsKey(steel + carbon)) {
                totalForgedSwords++;
                String swordName = swordTable.get(steel +  carbon);
                swordsForged.putIfAbsent(swordName, 0);
                swordsForged.put(swordName, swordsForged.get(swordName) + 1);
            } else {
                carbonStack.push(carbon + 5);
            }
        }


        if (totalForgedSwords > 0) {
            System.out.println("You have forged " + totalForgedSwords + " swords.");
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (steelQueue.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            System.out.print("Steel left: ");
            steelQueue.forEach(e -> {
                if (steelQueue.size() > 1) {
                    System.out.print(steelQueue.poll() + ", ");
                } else {
                    System.out.println(steelQueue.poll());
                }
            });
        }

        if (carbonStack.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            System.out.print("Carbon left: ");
            carbonStack.forEach(e -> {
                if (carbonStack.size() > 1) {
                    System.out.print(carbonStack.pop() + ", ");
                } else {
                    System.out.println(carbonStack.pop());
                }
            });
        }

        swordsForged.forEach((k, v) -> {
            System.out.printf("%s: %d%n", k, v);
        });
    }
}
