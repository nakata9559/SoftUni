package _02_StacksAndQueues_Exc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _09_PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfPlants = Integer.parseInt(scanner.nextLine());
        int numOfDays = 0;
        Deque<Integer> pesticide = new ArrayDeque<>();
        Deque<Integer> buffer = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(pesticide::push);

        boolean plantDying = true;

        while (true) {
            boolean plantsDyingThisSesion = false;
            while (!pesticide.isEmpty()) {
                buffer.push(pesticide.peek());
                int currentValue = pesticide.pop();
                if (pesticide.isEmpty()) {
                    break;
                }
                int nextValue = pesticide.peek();

                if (currentValue > nextValue) {
                    plantsDyingThisSesion = true;
                    buffer.pop();
                }
            }
            while (!buffer.isEmpty()) {
                pesticide.push(buffer.pop());
            }
            plantDying = plantsDyingThisSesion;
            if (!plantDying) {
                break;
            }
            numOfDays++;
        }
        System.out.println(numOfDays);
    }
}