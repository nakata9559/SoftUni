package _09_FunctionalPrograming_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _02_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<String, Integer> intParser = Integer::parseInt;

        List<Integer> nums = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(intParser)
                .collect(Collectors.toList());

        int count = nums.size();

        int sum = nums.stream().mapToInt(e -> e).sum();

        System.out.printf("Count = %d%n" +
                "Sum = %d%n",
                count,
                sum);
    }
}
