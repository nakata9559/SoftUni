package _16_Generics_Exc._04_GenericSwapMethodInteger;

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

    public void swap(int idx1, int idx2) {
        T[] arr = (T[]) this.list.toArray();
        T buffer = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = buffer;
        this.list = List.of(arr);
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
