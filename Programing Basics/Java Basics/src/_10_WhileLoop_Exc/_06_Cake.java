package _10_WhileLoop_Exc;

import java.util.Scanner;

public class _06_Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cakeLength = Integer.parseInt(scanner.nextLine());
        int cakeWidth = Integer.parseInt(scanner.nextLine());
        int pieces = cakeWidth * cakeLength;

        while (pieces > 0) {

            String cutString = scanner.nextLine();

            if (cutString.equals("STOP")) {
                break;
            }

            pieces -= Integer.parseInt(cutString);

        }

        if (pieces < 0) {
            System.out.println("No more cake left! You need " + Math.abs(pieces) + " pieces more.");
        } else {
            System.out.println(pieces + " pieces are left.");
        }
    }
}
