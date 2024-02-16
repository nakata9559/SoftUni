package _09_WhileLoop_Lab;

import java.util.Scanner;

public class _06_MaxNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int highest = Integer.MIN_VALUE;

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {

            int num = Integer.parseInt(input);

            if (num > highest) {
                highest = num;
            }

            input = scanner.nextLine();
        }
        System.out.println(highest);
    }
}
