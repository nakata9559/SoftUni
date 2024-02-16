package _16_Generics_Exc._09_CustomListIterator;

import java.util.*;

public class CustomList<T extends Comparable<T>> {
    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    public void remove(int index) {
        checkIndex(index);
        this.list.remove(index);
    }

    public boolean contains(T element) {
        return this.list.contains(element);
    }

    public void swap(int idx1, int idx2) {
        checkIndex(idx1);
        checkIndex(idx2);
        T item1 = list.get(idx1);
        T item2 = list.get(idx2);
        this.list.set(idx1, item2);
        this.list.set(idx2, item1);
    }

    public int countGreaterThan(T itemToCompare) {
        int counter = 0;

        for (T t : list) {
            if (t.compareTo(itemToCompare) > 0) {
                counter++;
            }
        }

        return counter;
    }

    public T getMax() {
        checkEmpty();
        return Collections.max(this.list);
    }

    public T getMin() {
        checkEmpty();
        return Collections.min(this.list);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        this.list.forEach(e -> {
            output.append(e).append(System.lineSeparator());
        });

        return output.toString();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.list.size()) {
            throw new IndexOutOfBoundsException("Out of bounds!");
        }
    }

    private void checkEmpty() {
        if (this.list.isEmpty()) {
            throw new IllegalStateException("Empty!");
        }
    }

    public int size() {
        return this.list.size();
    }

    public T get(int index) {
        return this.list.get(index);
    }

    public Iterator iterator() {
        return list.iterator();

    }

    public void print() {
        Iterator it = this.iterator();
        it.forEachRemaining(a ->{
            if(a != null){
                System.out.println(a);
            }
        });
    }
}
