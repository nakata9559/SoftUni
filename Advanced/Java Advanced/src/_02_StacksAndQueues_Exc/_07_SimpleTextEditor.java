package _02_StacksAndQueues_Exc;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _07_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = "";
        Deque<String> stack = new ArrayDeque<>();
        int numOfOperations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfOperations; i++) {
            String[] command = scanner.nextLine().split("\\s+");

            switch (command[0]) {
                case "1":
                    stack.push(text);
                    text += command[1];
                    break;
                case "2":
                    stack.push(text);
                    int count = Integer.parseInt(command[1]);
                    text = text.substring(0, text.length() - count);
                    break;
                case "3":
                    int index = Integer.parseInt(command[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    text = stack.pop();
                    break;
            }
        }
    }
}
