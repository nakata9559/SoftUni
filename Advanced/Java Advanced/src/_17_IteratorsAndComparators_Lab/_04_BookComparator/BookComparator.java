package _17_IteratorsAndComparators_Lab._04_BookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    public int compare(Book bookOne, Book bookTwo) {
        if (bookOne.getTitle().compareTo(bookTwo.getTitle()) < 0) {
            return -1;
        } else if (bookOne.getTitle().compareTo(bookTwo.getTitle()) > 0) {
            return 1;
        } else {
            if (bookOne.getYear() < bookTwo.getYear()) {
                return -1;
            } else if (bookOne.getYear() > bookTwo.getYear()) {
                return 1;
            }
        }
        return 0;
    }
}
