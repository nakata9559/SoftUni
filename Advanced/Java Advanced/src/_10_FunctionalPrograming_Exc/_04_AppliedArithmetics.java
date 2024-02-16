package _10_FunctionalPrograming_Exc;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class _04_AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Function<String, UnaryOperator<Integer>> func = cmd -> {
            switch (cmd) {
                case "add":
                    return n -> n + 1;
                case "multiply":
                    return n -> n * 2;
                case "subtract":
                    return n -> n - 1;
                default:
                    return n -> n;
            }
        };

        String command = scanner.nextLine();

        while (!"end".equals(command)) {

            if ("print".equals(command)) {
                System.out.println(String.join(" ", Arrays.stream(nums)
                        .map(String::valueOf)
                        .toArray(String[]::new)));

                command = scanner.nextLine();
                continue;
            }

            for (int i = 0; i < nums.length; i++) {
                nums[i] = func.apply(command).apply(nums[i]);
            }

            command = scanner.nextLine();
        }

    }
}
