package _17_IteratorsAndComparators_Lab._03_ComparableBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthors(String... authors) {
        if (authors.length == 0) {
            this.authors = new ArrayList<>();
        } else {
            this.authors = new ArrayList<>(Arrays.asList(authors));
        }
    }

    public Book (String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    public List<String> getAuthors() {
        return authors;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Book book) {
        if (this.getTitle().compareTo(book.getTitle()) < 0) {
            return -1;
        } else if (this.getTitle().compareTo(book.getTitle()) > 0) {
            return 1;
        } else {
            if (this.getYear() < book.getYear()) {
                return -1;
            } else if (this.getYear() > book.getYear()) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Year: %s", this.getTitle(), this.getYear());
    }
}
