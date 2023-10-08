package _00_MoreExercises._03_Arrays_MoreExc;

import java.util.Arrays;
import java.util.Scanner;

public class _04_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(String
                .join(" ", Arrays.stream(nums)
                        .mapToObj(String::valueOf)
                        .toArray(String[]::new)));
    }
}
