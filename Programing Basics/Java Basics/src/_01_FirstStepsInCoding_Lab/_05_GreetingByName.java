package _01_FirstStepsInCoding_Lab;

import java.util.Scanner;

public class _05_GreetingByName {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
    }
}
