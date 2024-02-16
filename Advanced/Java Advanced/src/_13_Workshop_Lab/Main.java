package _13_Workshop_Lab;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SmartArray smartArray = new SmartArray();
        CustomStack customStack = new CustomStack();

        smartArray.add(1);
        smartArray.add(2);
        smartArray.add(3);
        smartArray.add(4);
        smartArray.add(5);
        smartArray.add(6);
        smartArray.add(7);
        smartArray.add(8);
        smartArray.add(9);

        smartArray.remove(4);

        smartArray.add(5, 222);

        System.out.println(smartArray.contains(5));
        System.out.println(smartArray.contains(3));
        smartArray.forEach(e -> {
            System.out.printf("%d ", e);
            smartArray.remove(0);
        });

        System.out.println();
        System.out.println();

        customStack.push(1);
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);
        customStack.push(5);
        customStack.push(6);
        customStack.push(7);
        customStack.push(8);
        customStack.push(9);

        System.out.println(customStack.pop());

        System.out.println(customStack.peek());

        customStack.forEach(e -> {
            System.out.printf("%d ", customStack.peek());
            customStack.pop();
        });

        System.out.println();
    }
}
