package _21_Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _01_ChickenSnack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> moneyStack = new ArrayDeque<>();
        Deque<Integer> pricesQueue = new ArrayDeque<>();

        int foodEaten = 0;

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(moneyStack::push);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(pricesQueue::offer);

        while (!moneyStack.isEmpty() && !pricesQueue.isEmpty()){
            int currentMoney = moneyStack.pop();
            int currentPrice = pricesQueue.poll();

            if (currentMoney == currentPrice) {
                foodEaten++;
            } else if (currentMoney > currentPrice) {
                foodEaten++;
                if (moneyStack.isEmpty()) {
                    moneyStack.push(currentMoney);
                } else {
                    moneyStack.push(moneyStack.pop() + currentMoney - currentPrice);
                }
            }
        }
        if (foodEaten == 0) {
            System.out.println("Henry remained hungry. He will try next weekend again.");
        } else if (foodEaten == 1) {
            System.out.printf("Henry ate: %d food.%n", foodEaten);
        } else if (foodEaten < 4) {
            System.out.printf("Henry ate: %d foods.%n", foodEaten);
        } else {
            System.out.printf("Gluttony of the day! Henry ate %d foods.%n", foodEaten);
        }
    }
}
