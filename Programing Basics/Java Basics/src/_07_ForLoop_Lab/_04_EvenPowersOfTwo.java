package _07_ForLoop_Lab;

import java.util.Scanner;

public class _04_EvenPowersOfTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int step = Integer.parseInt(scanner.nextLine());

        for (int n = 0; n <= step; n += 2) {
            double result = Math.pow(2, n);
                System.out.printf("%.0f%n", result);
        }
    }
}
