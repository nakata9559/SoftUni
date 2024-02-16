package _16_Generics_Exc._05_GenericCountMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfItems = Integer.parseInt(scanner.nextLine());
        Counter counter = new Counter();

        while (numOfItems-- > 0) {
            counter.add(scanner.nextLine());
        }

        String itemToCompare = scanner.nextLine();

        System.out.println(counter.compare(itemToCompare));
    }
}
