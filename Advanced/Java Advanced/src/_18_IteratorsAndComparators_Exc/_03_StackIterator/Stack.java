package _18_IteratorsAndComparators_Exc._03_StackIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack implements Iterable<Integer> {
    private List<Integer> stack;
    private int size = 0;

    public Stack() {
        this.stack = new ArrayList<>();
    }

    public void setStack (String... numbers) {
        for (int i = 1; i < numbers.length; i++) {
            this.stack.add(Integer.parseInt(numbers[i].replaceAll(",", "")));
            this.size++;
        }
    }

    public void pop() {
        if (this.size > 0) {
            this.stack.remove(this.size-- - 1);
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new CustomIterator<>(this.stack);
    }
}
