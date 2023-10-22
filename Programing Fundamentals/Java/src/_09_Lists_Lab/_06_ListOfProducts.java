package _09_Lists_Lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _06_ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfProducts = Integer.parseInt(scanner.nextLine());

        List<String> products = new ArrayList<>();

        for (int i = 0; i < numOfProducts; i++) {
            products.add(scanner.nextLine());
        }

        Collections.sort(products);

        for (int i = 1; i <= numOfProducts; i++) {
            System.out.printf("%d.%s%n", i, products.get(i - 1));
        }
    }
}
