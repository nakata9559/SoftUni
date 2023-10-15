package _08_Methods_Exc;

import java.util.Scanner;

public class _08_FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("%.2f", factorialDivision(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine())));
    }

    public static double factorialDivision(int num1, int num2) {
        double firstFactorial = 1;
        double secondFactorial = 1;

        for (int i = 1; i <= num1; i++) {
            firstFactorial *= i;
        }

        for (int i = 1; i <= num2; i++) {
            secondFactorial *= i;
        }

        return firstFactorial / secondFactorial;
    }
}
