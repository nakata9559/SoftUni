package _00_MoreExercises._05_WhileLoop_MoreExc;

import java.util.Scanner;

public class _05_AverageNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int numSum = 0;

        for (int i = 0; i < n; i++) {

            int num = Integer.parseInt(scanner.nextLine());
            numSum += num;

        }
        double ave = 1.0 * numSum / n;

        System.out.printf("%.2f", ave);
    }
}
