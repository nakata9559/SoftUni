package _17_IteratorsAndComparators_Lab._04_BookComparator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Book bookOne = new Book("_05_Inheritance_Lab._01_SingleInheritance._05_Inheritance_Lab._02_HierarchicalInheritance._09_Polymorphism_Lab._03_Animals._09_Polymorphism_Lab._04_WildFarm.Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        List<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);

        books.sort(new BookComparator());

        for (Book book : books) {
            System.out.println(book);
        }
    }
}
