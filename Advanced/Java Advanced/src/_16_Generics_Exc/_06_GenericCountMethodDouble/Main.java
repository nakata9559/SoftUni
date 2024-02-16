package _16_Generics_Exc._06_GenericCountMethodDouble;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfItems = Integer.parseInt(scanner.nextLine());
        Counter counter = new Counter();

        while (numOfItems-- > 0) {
            counter.add(Double.parseDouble(scanner.nextLine()));
        }

        Double itemToCompare = Double.parseDouble(scanner.nextLine());

        System.out.println(counter.compare(itemToCompare));
    }
}
