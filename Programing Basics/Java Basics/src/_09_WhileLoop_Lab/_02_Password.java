package _09_WhileLoop_Lab;

import java.util.Scanner;

public class _02_Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = scanner.nextLine();
        String inputPass = scanner.nextLine();

        while (!inputPass.equals(password)) {
            inputPass = scanner.nextLine();
        }

        System.out.println("Welcome " + username + "!");
    }
}
