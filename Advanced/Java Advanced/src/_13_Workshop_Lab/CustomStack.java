package _13_Workshop_Lab;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomStack {
    private static final int INITIAL_CAPACITY = 4;
    private int[] items;
    private int size;
    private int capacity;

    public CustomStack() {
        this.capacity = INITIAL_CAPACITY;
        this.items = new int[this.capacity];
    }

    public int getSize() {
        return this.size;
    }

    public void push(int element) {
        if (this.size == this.capacity) resize();
        this.items[this.size++] = element;
    }

    public int pop() {
        checkEmpty();
        int element = this.items[this.size - 1];
        this.items[this.size - 1] = 0;
        this.size--;
        if (this.capacity / 2 >= this.size) shrink();
        return element;
    }

    public int peek() {
        checkEmpty();
        return this.items[this.size - 1];
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.items[i]);
            if (this.capacity / 2 <= i + 1) i = - 1;
        }
    }

    private void shrink() {
        this.capacity /= 2;
        int[] temp = new int[this.capacity];
        System.arraycopy(this.items, 0, temp, 0, this.size);
        this.items = temp;
    }

    private void checkEmpty() {
        if (this.size == 0) throw new NoSuchElementException("CustomStack is empty");
    }

    private void resize() {
        this.capacity *= 2;
        int[] temp = new int[this.capacity];

        System.arraycopy(items, 0, temp, 0, this.size);

        this.items = temp;
    }
}
