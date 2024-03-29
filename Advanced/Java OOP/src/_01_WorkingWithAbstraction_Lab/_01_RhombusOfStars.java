package _01_WorkingWithAbstraction_Lab;

import java.util.Scanner;

public class _01_RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        for (int stars = 1; stars <= size; stars++) {
            printRow(size, stars);
        }

        for (int stars = size - 1; stars >= 1; stars--) {
            printRow(size, stars);
        }
    }

    static void printRow(int size, int stars) {

        for (int i = 0; i < size - stars; i++) {
            System.out.print(" ");
        }

        for (int i = 0; i < stars; i++) {
            System.out.print("* ");
        }

        System.out.println();
    }
}
