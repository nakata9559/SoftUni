package _07_ForLoop_Lab;

import java.util.Scanner;

public class _02_NumbersFromNToOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());

        for (int num = num1; num >= 1; num--) {
            System.out.println(num);
        }
    }
}
