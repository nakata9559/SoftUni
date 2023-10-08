package _06_Arrays_Exc;

import java.util.Arrays;
import java.util.Scanner;

public class _05_TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < nums.length; i++) {
            boolean biggerNum = true;
            boolean checked = false;

            for (int j = i + 1; j < nums.length; j++) {
                checked = true;

                if (nums[i] <= nums[j]) {
                    biggerNum = false;
                    break;
                }
            }

            if (biggerNum && checked || i == nums.length - 1) {
                System.out.printf("%d ", nums[i]);
            }
        }
    }
}
