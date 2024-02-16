package _10_Lists_Exc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _05_BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers =
                Arrays.stream(scanner.nextLine()
                        .split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer> specialNum =
                Arrays.stream(scanner.nextLine()
                        .split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());


        for (int i = 0; i < numbers.size(); i++) {

            if (numbers.get(i).equals(specialNum.get(0))) {
                for (int k = i - 1; k >= i - specialNum.get(1); k--) {
                    if (k >= 0) {
                        numbers.set(k, 0);
                    } else {
                        break;
                    }
                }

                for (int k = i + 1; k <= i + specialNum.get(1); k++) {
                    if (k <= numbers.size() - 1) {
                        numbers.set(k, 0);
                    } else {
                        break;
                    }
                }
                numbers.set(i, 0);
            }

        }

        int sum = 0;

        for (int element : numbers) {
            sum += element;
        }
        System.out.println(sum);
    }
}
