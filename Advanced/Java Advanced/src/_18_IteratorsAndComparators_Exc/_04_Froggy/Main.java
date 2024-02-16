package _18_IteratorsAndComparators_Exc._04_Froggy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Lake lake = new Lake(Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray());

        scanner.nextLine();

        lake.forEach(e -> {
            if (lake.isLastElement()) {
                System.out.println(e);
            } else {
                System.out.printf("%d, ", e);
            }
        });
    }
}
