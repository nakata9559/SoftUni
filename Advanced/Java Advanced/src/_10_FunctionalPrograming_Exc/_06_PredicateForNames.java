package _10_FunctionalPrograming_Exc;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class _06_PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lengthCheck = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split("\\s+");

        Predicate<String> validator = e -> e.length() <= lengthCheck;

        Arrays.stream(names)
                .filter(validator)
                .forEach(System.out::println);
    }
}
