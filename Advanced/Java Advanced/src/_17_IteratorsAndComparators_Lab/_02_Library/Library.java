package _17_IteratorsAndComparators_Lab._02_Library;

import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book[] books;

    public Library (Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibraryIterator();
    }

    class LibraryIterator implements Iterator<Book> {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < books.length;
        }

        public Book next() {
            return books[counter++];
        }
    }
}
