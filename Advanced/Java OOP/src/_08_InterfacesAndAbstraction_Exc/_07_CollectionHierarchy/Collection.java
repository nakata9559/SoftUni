package _08_InterfacesAndAbstraction_Exc._07_CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    private static final int MAX_SIZE = 100;
    private int maxSize;
    protected List<String> items;

    public Collection() {
        this.maxSize = MAX_SIZE;
        this.items = new ArrayList<>();
    }
}
