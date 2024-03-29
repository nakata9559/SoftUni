package _19_BasicAlgorithms_Lab;

import java.util.Scanner;

public class _02_RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long num = Long.parseLong(scanner.nextLine());

        System.out.println(factorial(num));
    }

    public static long factorial(long num) {
        return num == 1 ? 1 : factorial(num - 1) * num;
    }
}
