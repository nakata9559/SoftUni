package _09_Polymorphism_Lab._03_Animals;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog("Usho", "kokal");
        Animal cat = new Cat("Pisa", "salam");

        System.out.println(dog.explainSelf());
        System.out.println(cat.explainSelf());
    }
}
