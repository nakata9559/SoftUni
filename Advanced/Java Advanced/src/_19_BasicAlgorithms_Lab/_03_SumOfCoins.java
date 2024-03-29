package _19_BasicAlgorithms_Lab;

import java.util.*;

public class _03_SumOfCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> coins = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(": ")[1].split(", "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .forEachOrdered(coins::push);

        int sum = Integer.parseInt(scanner.nextLine().split(": ")[1]);

        Map<Integer, Integer> coinsCountEach = new LinkedHashMap<>();
        int coinsCount = 0;

        while (!coins.isEmpty()) {
            int coin = coins.pop();
            while (sum - coin >= 0) {
                coinsCountEach.putIfAbsent(coin, 0);
                coinsCountEach.put(coin, coinsCountEach.get(coin) + 1);
                coinsCount++;
                sum -= coin;
            }
        }


        if (sum == 0) {
            System.out.printf("Number of coins to take: %d%n", coinsCount);
            coinsCountEach.forEach((k, v) -> {
                if (v != 0) {
                    System.out.printf("%d coin(s) with value %d%n",v, k);
                }
            });
        } else {
            System.out.println("Error");
        }
    }
}
