package _16_Generics_Exc._01_GenericBox;

public class Box<T> {
    private T value;

    public Box (T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value.getClass().getName() + ": " + this.value;
    }
}
