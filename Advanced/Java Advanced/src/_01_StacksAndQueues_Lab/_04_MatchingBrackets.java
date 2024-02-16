package _01_StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _04_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> indexes = new ArrayDeque<>();

        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            if ('(' == input.charAt(i)) {
                indexes.push(i);

            } else if (')' == input.charAt(i)) {
                int firstIndex = indexes.pop();
                System.out.println(input.substring(firstIndex, i + 1));
            }
        }
    }
}
