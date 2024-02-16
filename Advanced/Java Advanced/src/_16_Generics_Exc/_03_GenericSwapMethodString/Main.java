package _16_Generics_Exc._03_GenericSwapMethodString;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());
        Box box = new Box<>();

        while (lines-- > 0) {
            box.add(scanner.nextLine());
        }

        int[] swapIndexes = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        box.swap(swapIndexes[0], swapIndexes[1]);

        System.out.println(box);
    }
}
