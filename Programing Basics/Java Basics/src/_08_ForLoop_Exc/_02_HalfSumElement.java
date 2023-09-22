package _08_ForLoop_Exc;

import java.util.Scanner;

public class _02_HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int highest = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            sum += num;
            if (num > highest) {
                highest = num;
            }
        }

        sum -= highest;
        int diff = highest - sum;

        if (sum == highest){
            System.out.println("Yes");
            System.out.println("Sum = " + sum);
        } else {
            System.out.println("No");
            System.out.println("Diff = " + Math.abs(diff));
        }
    }
}
