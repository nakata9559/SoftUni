package _01_StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _08_BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();

        while (true) {
            String input = scanner.nextLine();
            if ("Home".equals(input)) {
                break;
            }

            if ("back".equals(input)) {
                if (stack.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    forward.addFirst(stack.peek());
                    stack.pop();
                    System.out.println(stack.peek());
                }
            } else if ("forward".equals(input)) {
                if (forward.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(forward.peek());
                    stack.push(forward.pop());
                }
            } else {
                System.out.println(input);
                stack.push(input);
                forward.clear();
            }
        }
    }
}
