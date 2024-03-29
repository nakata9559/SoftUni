package _19_BasicAlgorithms_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _01_RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(sum(nums, 0));
    }

    public static int sum(int[] nums, int index) {
        return index >= nums.length ? 0 : sum(nums, index + 1) + nums[index];
    }
}
