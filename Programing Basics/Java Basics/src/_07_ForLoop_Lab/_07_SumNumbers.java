package _07_ForLoop_Lab;

import java.util.Scanner;

public class _07_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersCount = Integer.parseInt(scanner.nextLine());

        int sum = 0;

        for (int next = 0; next < numbersCount; next++) {
            int number = Integer.parseInt(scanner.nextLine());
            sum += number;
        }
        System.out.println(sum);
    }
}
