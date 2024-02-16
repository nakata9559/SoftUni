package _00_MoreExercises._04_ForLoop_MoreExc;

import java.util.Scanner;

public class _08_EqualPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nCouples = Integer.parseInt(scanner.nextLine());

        int diff = Integer.MIN_VALUE;
        int sumOld = 0;
        int sumNew = 0;

        for (int i = 0; i < nCouples; i++) {
            sumOld = sumNew;

            int num1 = Integer.parseInt(scanner.nextLine());
            int num2 = Integer.parseInt(scanner.nextLine());

            sumNew = num1 + num2;

            if (nCouples == 1) {
                System.out.printf("Yes, value=%d", sumNew);
                return;
            }

            if (diff < Math.abs(sumNew - sumOld) && i != 0) {
                diff = Math.abs(sumNew - sumOld);
            }
        }

        if (sumOld == sumNew) {
            System.out.printf("Yes, value=%d", sumNew);
        } else {
            System.out.printf("No, maxdiff=%d", diff);
        }
    }
}
