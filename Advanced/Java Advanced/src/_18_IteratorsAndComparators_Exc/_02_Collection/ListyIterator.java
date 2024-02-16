package _18_IteratorsAndComparators_Exc._02_Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> list;
    private int index;

    public ListyIterator(String... text) {
        this.index = 0;
        this.list = new ArrayList<>();
        this.list.addAll(Arrays.asList(text).subList(1, text.length));
    }

    public boolean move() {
        if (this.index < this.list.size() - 1) {
            this.index++;
            return true;
        } else {
            return false;
        }
    }

    public void print() {
        if (this.index < list.size()) {
            System.out.println(list.get(index));
        } else {
            System.out.println("Invalid Operation!");
        }
    }

    public boolean hasNext() {
        return this.index < this.list.size() - 1;
    }

    @Override
    public Iterator<String> iterator() {
        return new ListIterator();
    }

    class ListIterator implements Iterator<String> {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < list.size();
        }

        public String next() {
            return list.get(counter++);
        }
    }
}
