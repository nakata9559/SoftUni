package _09_FunctionalPrograming_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", nums.stream()
                .map(String::valueOf)
                .collect(Collectors.toList())));

        nums.sort((a, b) -> a.compareTo(b));

        System.out.println(String.join(", ", nums.stream()
                .map(String::valueOf)
                .collect(Collectors.toList())));
    }
}
