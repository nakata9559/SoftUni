package _10_FunctionalPrograming_Exc;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class _03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<Integer[], Integer> filter = arr -> Arrays.stream(arr).min(Integer::compareTo).get();

        System.out.println(filter.apply(
                Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new)));
    }
}
