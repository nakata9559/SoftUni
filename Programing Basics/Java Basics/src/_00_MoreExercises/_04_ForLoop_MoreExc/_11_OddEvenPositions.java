package _00_MoreExercises._04_ForLoop_MoreExc;

import java.util.Scanner;

public class _11_OddEvenPositions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double oddSum = 0;
        double oddMin = Double.MAX_VALUE;
        double oddMax = -Double.MAX_VALUE;
        double evenSum = 0;
        double evenMin = Double.MAX_VALUE;
        double evenMax = -Double.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                double oddNum = Double.parseDouble(scanner.nextLine());

                oddSum += oddNum;

                if (oddMin > oddNum) {
                    oddMin = oddNum;
                }

                if (oddMax < oddNum) {
                    oddMax = oddNum;
                }

            } else {
                double evenNum = Double.parseDouble(scanner.nextLine());

                evenSum += evenNum;

                if (evenMin > evenNum) {
                    evenMin = evenNum;
                }

                if (evenMax < evenNum) {
                    evenMax = evenNum;
                }
            }
        }

        if (n < 1) {
            
            System.out.printf("OddSum=%.2f,%n", oddSum);
            System.out.printf("OddMin=No,%n");
            System.out.printf("OddMax=No,%n");
            System.out.printf("EvenSum=%.2f,%n", evenSum);
            System.out.printf("EvenMin=No,%n");
            System.out.printf("EvenMax=No%n");

        } else if (n == 1) {

            System.out.printf("OddSum=%.2f,%n", oddSum);
            System.out.printf("OddMin=%.2f,%n", oddMin);
            System.out.printf("OddMax=%.2f,%n", oddMax);
            System.out.printf("EvenSum=%.2f,%n", evenSum);
            System.out.printf("EvenMin=No,%n");
            System.out.printf("EvenMax=No%n");

        } else {

            System.out.printf("OddSum=%.2f,%n", oddSum);
            System.out.printf("OddMin=%.2f,%n", oddMin);
            System.out.printf("OddMax=%.2f,%n", oddMax);
            System.out.printf("EvenSum=%.2f,%n", evenSum);
            System.out.printf("EvenMin=%.2f,%n", evenMin);
            System.out.printf("EvenMax=%.2f", evenMax);
        }
    }
}
