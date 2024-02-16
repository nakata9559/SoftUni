package _15_Generics_Lab._04_ListUtilities;

import java.util.List;

public class ListUtils {

    public static <T extends Comparable> T getMin(List<T> list) {
        if (list.isEmpty()) throw new IllegalArgumentException();
        return list.stream().min(Comparable::compareTo).get();
    }

    public static <T extends Comparable> T getMax(List<T> list) {
        if (list.isEmpty()) throw new IllegalArgumentException();
        return list.stream().max(Comparable::compareTo).get();
    }
}
