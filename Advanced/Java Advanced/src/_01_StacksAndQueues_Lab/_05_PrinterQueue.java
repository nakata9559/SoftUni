package _01_StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _05_PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        while (true) {
            String input = scanner.nextLine();
            if ("print".equals(input)) {
                break;
            }

            if ("cancel".equals(input)) {
                if (queue.isEmpty()) {
                    System.out.println("_12_SOLID_Exc.Printer is on standby");
                } else {
                    System.out.println("Canceled" + " " + queue.poll());
                }
            } else {
                queue.offer(input);
            }
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
