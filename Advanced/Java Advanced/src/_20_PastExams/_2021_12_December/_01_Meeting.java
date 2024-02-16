package _20_PastExams._2021_12_December;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _01_Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matchesCount = 0;
        Deque<Integer> malesStack = new ArrayDeque<>();
        Deque<Integer> femalesQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(malesStack::push);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(femalesQueue::offer);

        while (true) {
            while (!malesStack.isEmpty() && malesStack.peek() % 25 == 0 && malesStack.peek() != 0) {
                malesStack.pop();
                if (malesStack.isEmpty()) {
                    break;
                }
                malesStack.pop();
            }

            while (!malesStack.isEmpty() && malesStack.peek() <= 0) {
                malesStack.pop();
            }

            if (malesStack.isEmpty()) {
                break;
            }

            while (!femalesQueue.isEmpty() && femalesQueue.peek() % 25 == 0 && femalesQueue.peek() != 0) {
                femalesQueue.poll();
                if (femalesQueue.isEmpty()) {
                    break;
                }
                femalesQueue.poll();
            }

            while (!femalesQueue.isEmpty() && femalesQueue.peek() <= 0) {
                femalesQueue.poll();
            }

            if (femalesQueue.isEmpty()) {
                break;
            }

            int femalesValue = femalesQueue.poll();
            int maleValue = malesStack.pop();

            if (femalesValue == maleValue) {
                matchesCount++;
            } else {
                malesStack.push(maleValue - 2);
            }
        }

        System.out.println("Matches: " + matchesCount);

        if (malesStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.printf("Males left: %s%n",
                    String.join(", ", malesStack.stream()
                            .map(String::valueOf)
                            .toArray(String[]::new)));
        }

        if (femalesQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.printf("Females left: %s%n",
                    String.join(", ", femalesQueue.stream()
                            .map(String::valueOf)
                            .toArray(String[]::new)));
        }
    }
}
