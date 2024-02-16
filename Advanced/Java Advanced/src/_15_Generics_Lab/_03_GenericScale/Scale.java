package _15_Generics_Lab._03_GenericScale;

public class Scale<T extends Comparable> {
    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        if (this.left.equals(this.right)) {
            return null;
        }
        return this.left.compareTo(right) > 0 ? this.left : this.right;
    }
}
