package _10_WhileLoop_Exc;

import java.util.Scanner;

public class _01_OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String requiredBook = scanner.nextLine();
        String searchedBook = scanner.nextLine();
        int booksChecked = 0;


        while (!searchedBook.equals(requiredBook) && !searchedBook.equals("No More Books")) {

            booksChecked++;
            searchedBook = scanner.nextLine();

        }

        if (searchedBook.equals(requiredBook)) {
            System.out.printf("You checked %d books and found it.", booksChecked);

        } else {
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.", booksChecked);
        }
    }
}
