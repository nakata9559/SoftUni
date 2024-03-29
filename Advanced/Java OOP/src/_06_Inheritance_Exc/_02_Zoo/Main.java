package _06_Inheritance_Exc._02_Zoo;

public class Main {
    public static void main(String[] args) {
        Lizard lizard = new Lizard("Gosho");
        Snake snake = new Snake("Pesho");
        Gorilla gorilla = new Gorilla("Stamat");
        Bear bear = new Bear("Minka");

        System.out.println(lizard.getName());
        System.out.println(snake.getName());
        System.out.println(gorilla.getName());
        System.out.println(bear.getName());
    }
}
