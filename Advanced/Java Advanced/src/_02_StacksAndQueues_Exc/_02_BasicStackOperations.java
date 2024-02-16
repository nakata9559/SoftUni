package _02_StacksAndQueues_Exc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numOfElements = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int N = numOfElements[0];
        int S = numOfElements[1];
        int X = numOfElements[2];

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            stack.push(numbers[i]);
        }

        for (int i = 0; i < S; i++) {
            stack.pop();
        }

        if (stack.contains(X)) {
            System.out.println("true");
        } else if (!stack.isEmpty()) {
            System.out.println(Collections.min(stack));
        } else {
            System.out.println(0);
        }
    }
}
