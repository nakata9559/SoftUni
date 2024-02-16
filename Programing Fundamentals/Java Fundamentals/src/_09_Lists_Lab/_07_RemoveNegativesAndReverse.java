package _09_Lists_Lab;

import java.util.*;
import java.util.stream.Collectors;

public class _07_RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers =
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 0 ) {
                numbers.remove(Integer.valueOf(numbers.get(i)));
                i--;
            }
        }

        if (numbers.size() > 0) {
            Collections.reverse(numbers);

            System.out.println(String.join(
                    " ", numbers.stream()
                            .map(String::valueOf)
                            .collect(Collectors.toList())));

        } else {
            System.out.println("empty");
        }
    }
}
