package _01_StacksAndQueues_Lab;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> reversedStack = new ArrayDeque<>();
        String inputString = scanner.nextLine().replaceAll("\\s+", "");

        Pattern pattern = Pattern.compile("[+\\-]*[0-9]+");
        Matcher matcher = pattern.matcher(inputString);

        while (matcher.find()) {
            reversedStack.push(Integer.parseInt(matcher.group()));
        }

        while (!reversedStack.isEmpty()) {
            stack.push(reversedStack.pop());
        }

        int result = 0;

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        System.out.println(result);
    }
}
