package _09_Polymorphism_Lab._01_MathOperation;

public class Main {
    public static void main(String[] args) {

        MathOperation math = new MathOperation();

        System.out.println(math.add(2, 2));
        System.out.println(math.add(3, 3, 3));
        System.out.println(math.add(4, 4, 4, 4));

    }
}
