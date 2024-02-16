package _20_PastExams._2022_06_June;

import java.util.*;

public class _01_ItSChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, String> chocolateTypes = new HashMap<>();
        chocolateTypes.put(30, "Milk Chocolate");
        chocolateTypes.put(50, "Dark Chocolate");
        chocolateTypes.put(100, "Baking Chocolate");

        Deque<Double> milkValuesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .forEach(milkValuesQueue::offer);

        Deque<Double> cacaoValuesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .forEach(cacaoValuesStack::push);

        Map<String, Integer> bakedChocolates = new TreeMap<>();

        while (!milkValuesQueue.isEmpty()
                && !cacaoValuesStack.isEmpty()) {
            double currentMilkValue = milkValuesQueue.poll();
            double currentCacaoValues = cacaoValuesStack.pop();
            int mixture = (int) ((currentCacaoValues / (currentMilkValue + currentCacaoValues)) * 100);

            if (chocolateTypes.containsKey(mixture)) {
                String type = chocolateTypes.get(mixture);

                bakedChocolates.putIfAbsent(type, 0);
                bakedChocolates.put(type, bakedChocolates.get(type) + 1);

            } else {
                milkValuesQueue.offer(currentMilkValue + 10);
            }
        }

        if (bakedChocolates.size() < 3) {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        } else {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        }

        bakedChocolates.forEach((k, v) -> {
            System.out.printf("# %s --> %d%n",k, v);
        });
    }
}
