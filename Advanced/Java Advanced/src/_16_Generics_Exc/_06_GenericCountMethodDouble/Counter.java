package _16_Generics_Exc._06_GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Counter<T extends Comparable> {
    private List<T> list;

    public Counter() {
        this.list = new ArrayList<>();
    }

    public void add(T item) {
        this.list.add(item);
    }

    public int compare(T itemToCompare) {
        return this.list.stream()
                .filter(e -> e.compareTo(itemToCompare) > 0)
                .collect(Collectors.toList())
                .size();
    }
}
