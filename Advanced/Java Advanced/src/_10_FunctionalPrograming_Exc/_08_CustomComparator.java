package _10_FunctionalPrograming_Exc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _08_CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        IntPredicate filterEvens = n -> n % 2 == 0;
//        IntPredicate filterOdds = n -> n % 2 != 0;
//
//        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+"))
//                .map(Integer::parseInt)
//                .sorted()
//                .collect(Collectors.toList());
//
//        nums.stream()
//                .filter(filterEvens::test)
//                .forEach(e -> System.out.print(e + " "));
//
//        nums.stream()
//                .filter(filterOdds::test)
//                .forEach(e -> System.out.print(e + " "));
//
//        System.out.println();

        Comparator<Integer> customComparator = (num1, num2) -> {
            if (num1 % 2 == 0 && num2 % 2 != 0) {
                return -1;

            } else if (num1 % 2 != 0 && num2 % 2 == 0) {
                return 1;

            } else {
                return num1.compareTo(num2);
            }
        };

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted(customComparator)
                .forEach(e -> System.out.print(e + " "));

        System.out.println();
    }
}
