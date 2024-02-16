package _09_WhileLoop_Lab;

import java.util.Scanner;

public class _03_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());

        while (num2 < num1) {
            num2 += Integer.parseInt(scanner.nextLine());
        }
        System.out.println(num2);
    }
}
