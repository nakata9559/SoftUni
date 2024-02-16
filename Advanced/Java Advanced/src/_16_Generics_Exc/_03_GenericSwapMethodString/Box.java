package _16_Generics_Exc._03_GenericSwapMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> list;

    public Box () {
        list = new ArrayList<>();
    }

    public void add(T item) {
        list.add(item);
    }

    public void swap(int index1, int index2) {
        T item1 = list.get(index1);
        T item2 = list.get(index2);
        this.list.set(index1, item2);
        this.list.set(index2, item1);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        this.list.forEach(e -> {
            output.append(String.valueOf(e.getClass()).replace("class ", "") + ": " + e + System.lineSeparator());
        });

        return output.toString();
    }
}
