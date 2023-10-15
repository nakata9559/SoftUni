package _08_Methods_Exc;

import java.util.Scanner;

public class _07_NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printMatrix(Integer.parseInt(scanner.nextLine()));
    }

    public static void printMatrix(int number) {
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                System.out.printf("%d ", number);
            }

            System.out.println();
        }
    }
}
