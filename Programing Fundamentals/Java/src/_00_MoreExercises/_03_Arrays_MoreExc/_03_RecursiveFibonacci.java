package _00_MoreExercises._03_Arrays_MoreExc;

import java.util.Scanner;

public class _03_RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fibonacciNum = Integer.parseInt(scanner.nextLine());

        int[] arr = new int[fibonacciNum];

        arr[0] = 1;

        if (fibonacciNum > 1) {
            arr[1] = 1;
        }

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        System.out.println(arr[fibonacciNum - 1]);
    }
}
