package _06_ConditionalStatementsAdvanced_Exc;

import java.util.Scanner;

public class _06_OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        char operator = scanner.nextLine().charAt(0);

        double result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                if (result % 2 == 0) {
                    System.out.printf("%d %c %d = %.0f - even", num1, operator, num2, result);
                } else {
                    System.out.printf("%d %c %d = %.0f - odd", num1, operator, num2, result);
                }
                break;

            case '-':
                result = num1 - num2;
                if (result % 2 == 0) {
                    System.out.printf("%d %c %d = %.0f - even", num1, operator, num2, result);
                } else {
                    System.out.printf("%d %c %d = %.0f - odd", num1, operator, num2, result);
                }
                break;

            case '*':
                result = num1 * num2;
                if (result % 2 == 0) {
                    System.out.printf("%d %c %d = %.0f - even", num1, operator, num2, result);
                } else {
                    System.out.printf("%d %c %d = %.0f - odd", num1, operator, num2, result);
                }
                break;

            case '/':
                if (num2 != 0) {
                    result = 1.0 * num1 / num2;
                    System.out.printf("%d %c %d = %.2f", num1, operator, num2, result);
                } else {
                    System.out.printf("Cannot divide %d by zero", num1);
                }
                break;

            case '%':
                if (num2 != 0) {
                    result = 1.0 * num1 % num2;
                    System.out.printf("%d %c %d = %.0f", num1, operator, num2, result);
                } else {
                    System.out.printf("Cannot divide %d by zero", num1);
                }
                break;
        }
    }
}
