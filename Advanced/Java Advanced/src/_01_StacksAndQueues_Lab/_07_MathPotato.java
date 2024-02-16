package _01_StacksAndQueues_Lab;

import java.util.*;
import java.util.stream.Collectors;

public class _07_MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split(" ");
        int numOfPasses = Integer.parseInt(scanner.nextLine());
        PriorityQueue<String> queue = new PriorityQueue<>();

        for (String child : children) {
            queue.offer(child);
        }

        int cycle = 1;

        while (queue.size() > 1) {
            for (int i = 1; i < numOfPasses; i++) {
                queue.offer(queue.poll());
            }

            if (isPrime(cycle)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + queue.poll());
    }

    static  boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if ((num % i) == 0)
                return false;
        }
        return true;
    }
}
