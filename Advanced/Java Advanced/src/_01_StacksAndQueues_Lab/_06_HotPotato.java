package _01_StacksAndQueues_Lab;

import java.util.*;
import java.util.stream.Collectors;

public class _06_HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> children = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        int numOfPasses = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();
        int currentPosition = 0;

        while (!children.isEmpty()) {
            for (int j = 1; j < numOfPasses; j++) {
                currentPosition++;
                if (currentPosition >= children.size()) {
                    currentPosition = 0;
                }
            }
            queue.offer(children.get(currentPosition));
            children.remove(currentPosition);

            if (currentPosition >= children.size()) {
                currentPosition = 0;
            }
        }

        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                System.out.println("Removed " + queue.poll());
            } else {
                System.out.println("Last is " + queue.poll());
            }
        }
    }
}
