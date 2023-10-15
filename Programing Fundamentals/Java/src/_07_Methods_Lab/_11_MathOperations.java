package _07_Methods_Lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class _11_MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int num2 = Integer.parseInt(scanner.nextLine());

        System.out.println(new DecimalFormat("0.##").format(result(num1, operator, num2)));
    }

    public static double result(int num1, String operator, int num2) {
        double sum = 0;

        switch (operator) {
            case "+":
                sum = num1 * 1.0 + num2 * 1.0;
                break;
            case "-":
                sum = num1 * 1.0 - num2 * 1.0;
                break;
            case "*":
                sum = num1 * 1.0 * num2;
                break;
            case "/":
                sum = num1 * 1.0 / num2;
                break;
        }

        return sum;
    }
}
