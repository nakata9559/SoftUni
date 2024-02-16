package _10_FunctionalPrograming_Exc;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.IntStream;

public class _09_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int upperBound = Integer.parseInt(scanner.nextLine());
        Integer[] intArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        BiPredicate<Integer, Integer[]> checkIfDivisible = (e1, e2) -> {
            for (Integer num : e2) {
                if (e1 % num != 0) {
                    return false;
                }
            }
            return true;
        };

        IntStream.range(1, upperBound + 1)
                .filter(n -> checkIfDivisible.test(n, intArr))
                .forEach(e -> System.out.print(e + " "));

        System.out.println();
    }
}
