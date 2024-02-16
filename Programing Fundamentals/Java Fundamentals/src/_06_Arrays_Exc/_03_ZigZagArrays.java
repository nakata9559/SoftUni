package _06_Arrays_Exc;

import java.util.Arrays;
import java.util.Scanner;

public class _03_ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfLines = Integer.parseInt(scanner.nextLine());

        int[] firstArray = new int[numOfLines];
        int[] secondArray = new int[numOfLines];

        for (int i = 0; i < numOfLines; i++) {
            int[] nums = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (i % 2 == 0) {
                firstArray[i] = nums[0];
                secondArray[i] = nums[1];
            } else {
                firstArray[i] = nums[1];
                secondArray[i] = nums[0];
            }
        }
        System.out.println(String.join(" ", Arrays.stream(firstArray)
                .mapToObj(String::valueOf)
                .toArray(String[]::new)));

        System.out.println(String.join(" ", Arrays.stream(secondArray)
                .mapToObj(String::valueOf)
                .toArray(String[]::new)));
    }
}
