package _10_FunctionalPrograming_Exc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.reverse(list);

        int num = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> filter = e -> e % num != 0;

        list.stream()
                .filter(filter)
                .forEach(e -> System.out.print(e + " "));

        System.out.println();
    }
}
