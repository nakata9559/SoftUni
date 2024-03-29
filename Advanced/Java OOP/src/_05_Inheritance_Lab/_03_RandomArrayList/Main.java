package _05_Inheritance_Lab._03_RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList strings = new RandomArrayList();
        strings.add(1);
        strings.add(2);
        strings.add(3);
        strings.add(4);

        System.out.println(strings.getRandomElement());
    }
}
