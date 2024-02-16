package _09_WhileLoop_Lab;

import java.util.Scanner;

public class _04_Sequence2KPlus1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lastNum = Integer.parseInt(scanner.nextLine());
        int nums = 1;

        while (nums <= lastNum) {
            System.out.println(nums);
            nums = nums * 2 + 1;
        }
    }
}
