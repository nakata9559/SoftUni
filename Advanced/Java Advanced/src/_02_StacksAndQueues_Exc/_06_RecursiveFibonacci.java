package _02_StacksAndQueues_Exc;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _06_RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long fibonacciNumber = Long.parseLong(scanner.nextLine());

        ArrayDeque<Long> queue = new ArrayDeque<>();

        queue.offer(Long.parseLong("1"));
        queue.offer(Long.parseLong("1"));

        for (int i = 0; i < fibonacciNumber; i++) {
            long previous = queue.poll();
            queue.offer(queue.peek() + previous);

        }
        System.out.println(queue.peek());
    }
}
