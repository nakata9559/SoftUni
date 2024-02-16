package _18_IteratorsAndComparators_Exc._03_StackIterator;

import java.util.Iterator;
import java.util.List;

public class CustomIterator<Integer> implements Iterator<Integer> {
    private List<Integer> stack;
    private int counter;

    public CustomIterator (List<Integer> stack) {
        this.stack = stack;
        this.counter = stack.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return this.counter >= 0;
    }

    public Integer next() {
        return this.stack.get(counter--);
    }
}
