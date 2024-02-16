package _09_WhileLoop_Lab;

import java.util.Scanner;

public class _07_MinNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lowest = Integer.MAX_VALUE;

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {

            int num = Integer.parseInt(input);

            if (num < lowest) {
                lowest = num;
            }

            input = scanner.nextLine();
        }
        System.out.println(lowest);
    }
}
