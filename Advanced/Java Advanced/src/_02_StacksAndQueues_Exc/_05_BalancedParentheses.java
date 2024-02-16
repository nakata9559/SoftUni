package _02_StacksAndQueues_Exc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("");

        System.out.println(isBalanced(input) ? "YES" : "NO");
    }

    private static boolean isBalanced(String[] input) {
        Deque<String> stack = new ArrayDeque<>();

        for (String eachChar : input) {
            String openBracket;

            switch (eachChar) {
                case "}":
                    if (stack.isEmpty()) {
                        return false;
                    }
                    openBracket = stack.pop();
                    if (!openBracket.equals("{")) {
                        return false;
                    }
                    break;

                case "]":
                    if (stack.isEmpty()) {
                    return false;
                    }
                    openBracket = stack.pop();
                    if (!openBracket.equals("[")) {
                        return false;
                    }
                    break;

                case ")":
                    if (stack.isEmpty()) {
                    return false;
                    }
                    openBracket = stack.pop();
                    if (!openBracket.equals("(")) {
                        return false;
                    }
                    break;

                default:
                    stack.push(eachChar);
                    break;
            }
        }
        return true;
    }
}
