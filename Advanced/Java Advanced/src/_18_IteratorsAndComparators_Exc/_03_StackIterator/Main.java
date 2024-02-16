package _18_IteratorsAndComparators_Exc._03_StackIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack numbers = new Stack();

        String command = scanner.nextLine();

        while (!"END".equals(command.split("\\s+")[0])) {
            switch (command.split("\\s+")[0]) {
                case "Push":
                    numbers.setStack(command.split("\\s+"));
                    break;

                case "Pop":
                    numbers.pop();
                    break;
            }
                command = scanner.nextLine();
        }

        if (numbers.getSize() == 0) {
            System.out.println("No elements");

        } else {
            for (int number : numbers) {
                System.out.println(number);
            }

            for (int number : numbers) {
                System.out.println(number);
            }
        }
    }
}
