package _10_WhileLoop_Exc;

import java.util.Scanner;

public class _07_Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());

        int freeArea = width * length * height;

        while (freeArea > 0) {

            String boxesString = scanner.nextLine();

            if (boxesString.equals("Done")) {
                System.out.println(freeArea + " Cubic meters left.");
                break;
            }
            freeArea -= Integer.parseInt(boxesString);
        }
        if (freeArea < 0) {
            System.out.println("No more free space! You need " + Math.abs(freeArea) + " Cubic meters more.");
        }
    }
}
