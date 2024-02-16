package _00_MoreExercises._04_Methods_MoreExc;

import java.util.Scanner;

public class _04_TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        int[] tribonacci = new int[num];

        for (int i = 0; i < tribonacci.length; i++) {
            if (i == 0) {
                tribonacci[i] = 1;
            } else if (i == 1) {
                tribonacci[i] = returnNum(tribonacci[i - 1], 0, 0);
            } else if (i == 2){
                tribonacci[i] = returnNum(tribonacci[i - 2], tribonacci[i - 1], 0);
            } else {
                tribonacci[i] = returnNum(tribonacci[i - 3], tribonacci[i - 2], tribonacci[i - 1]);
            }
            System.out.print(tribonacci[i] + " ");
        }
        System.out.println();
    }

    public static int returnNum(int num1, int num2, int num3) {
        return num1 + num2 + num3;
    }
}
