package _13_Workshop_Lab;

import java.util.function.Consumer;

public class SmartArray {
    private static final int INITIAL_CAPACITY = 4;
    private int[] data;
    private int size;
    private int capacity;

    public SmartArray()  {
        this.data = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    public void add(int element) {
        if (this.size == this.capacity) resize();
        this.data[this.size++] = element;
    }

    public int get(int index) {
        checkIndex(index);
        return this.data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(
                    String.format("Index %d out of bounds  for length %d",
                    index,
                    this.size));
        }
    }

    public int remove(int index) {
        checkIndex(index);
        this.size--;
        int removedElement = this.data[index];
        this.data = shiftLeft(index);
        return removedElement;
    }

    public boolean contains(int element) {
        for (int elem : data) {
            if (elem == element) return true;
        }
        return false;
    }

    public void add(int index, int element) {
        checkIndex(index);
        if (this.size == this.capacity) resize();
        this.size++;
        this.data = shiftRight(index);
        this.data[index] = element;
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }

    private void resize() {
        this.capacity *= 2;
        int[] temp = new int[this.capacity];

        System.arraycopy(data, 0, temp, 0, this.size);

        this.data = temp;
    }

    private void shrink() {
        this.capacity /= 2;
    }

    private int[] shiftLeft(int index) {
        checkIndex(index);
        if (this.capacity / 2 >= this.size) shrink();
        int[] temp = new int[this.capacity];

        System.arraycopy(this.data, 0, temp, 0, index);
        System.arraycopy(this.data, index + 1, temp, index, this.size + 1 - (index + 1));

        return temp;
    }

    private int[] shiftRight(int index) {
        checkIndex(index);
        if (this.size >= this.capacity) resize();
        int[] temp = new int[this.capacity];

        System.arraycopy(this.data, 0, temp, 0, index);
        System.arraycopy(this.data, index, temp, index + 1, this.size - (index + 1));

        return temp;
    }
}
