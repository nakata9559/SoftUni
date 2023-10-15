package _07_Methods_Lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class _08_MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1 = Double.parseDouble(scanner.nextLine());
        double num2 = Double.parseDouble(scanner.nextLine());

        System.out.println(new DecimalFormat("0.####").format(power(num1, num2)));
    }

    public static double power(double num1, double num2) {
        return Math.pow(num1, num2);
    }
}
