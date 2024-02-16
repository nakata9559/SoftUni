package _10_FunctionalPrograming_Exc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _07_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<List<Integer>, Integer> printSmallestNumIndex = e -> e.lastIndexOf(Collections.min(e));

        System.out.println(printSmallestNumIndex.apply(
                Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList())));
    }
}
