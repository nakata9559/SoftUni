package _06_Arrays_Exc;

import java.util.Arrays;
import java.util.Scanner;

public class _04_ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rotations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < rotations; i++) {
            int firstNum = nums[0];

            for (int j = 0; j < nums.length - 1; j++) {
                nums[j] = nums[j + 1];
            }

            nums[nums.length - 1] = firstNum;
        }

        System.out.println(String
                .join(" ", Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .toArray(String[]::new)));
    }
}
