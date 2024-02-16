package _02_StacksAndQueues_Exc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int numOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfCommands; i++) {
            int[] command = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (command[0] == 1) {
                stack.push(command[1]);
            } else if (command[0] == 2) {
                stack.pop();
            } else if (command[0] == 3) {
                System.out.println(Collections.max(stack));
            }
        }
    }
}
