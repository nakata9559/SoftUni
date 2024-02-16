package _02_StacksAndQueues_Exc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] commands = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int N = commands[0];
        int S = commands[1];
        int X = commands[2];

        ArrayDeque<Integer> elements = new ArrayDeque<>();

        int[] elementsInput = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < N; i++) {
            elements.offer(elementsInput[i]);
        }

        for (int i = 0; i < S; i++) {
            elements.poll();
        }

        if (elements.contains(X)) {
            System.out.println("true");
        } else if (elements.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(Collections.min(elements));
        }
    }
}
