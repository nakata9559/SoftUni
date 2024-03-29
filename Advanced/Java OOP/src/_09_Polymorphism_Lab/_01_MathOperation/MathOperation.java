package _09_Polymorphism_Lab._01_MathOperation;

public class MathOperation {

    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return this.add(a, b) + c;
    }

    public int add(int a, int b, int c, int d) {
        return this.add(a, b, c) + d;
    }
}
