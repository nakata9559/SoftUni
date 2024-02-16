package _00_MoreExercises._04_Methods_MoreExc;

import java.util.Scanner;

public class _02_CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int X1 = Integer.parseInt(scanner.nextLine());
        int Y1 = Integer.parseInt(scanner.nextLine());
        int X2 = Integer.parseInt(scanner.nextLine());
        int Y2 = Integer.parseInt(scanner.nextLine());

        int further1 = Math.abs(X1) + Math.abs(Y1);
        int further2 = Math.abs(X2) + Math.abs(Y2);

        if (further1 <= further2) {
            printPoints(X1, Y1);
        } else {
            printPoints(X2, Y2);
        }
    }
    public static void printPoints (int pointX, int pointY) {
        System.out.println("(" + pointX + ", " + pointY + ")");
    }
}
