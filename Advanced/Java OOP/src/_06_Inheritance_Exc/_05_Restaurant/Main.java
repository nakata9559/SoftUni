package _06_Inheritance_Exc._05_Restaurant;

public class Main{
    public static void main(String[] args) {
        Coffee coffee = new Coffee("Arzo", 25);

        System.out.println(coffee.getName());
        System.out.println(coffee.getMilliliters());
        System.out.println(coffee.getPrice());
        System.out.println(coffee.getCaffeine());
    }
}
