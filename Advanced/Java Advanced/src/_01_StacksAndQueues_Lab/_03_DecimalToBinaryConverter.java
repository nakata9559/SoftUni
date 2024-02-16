package _01_StacksAndQueues_Lab;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _03_DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int decimal = Integer.parseInt(scanner.nextLine());

        if (decimal == 0) {
            System.out.println(0);
            return;
        }

        while (decimal != 0) {
            stack.push(decimal % 2);
            decimal /= 2;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

        System.out.println();
    }
}
