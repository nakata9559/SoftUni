package _18_IteratorsAndComparators_Exc._01_ListyIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListyIterator listyIterator = null;

        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            switch (input.split("\\s+")[0]) {
                case "Create":
                    listyIterator = new ListyIterator(input.split("\\s+"));
                    break;

                case "Move":
                    System.out.println(listyIterator.move());
                    break;

                case "Print":
                    listyIterator.print();
                    break;

                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
