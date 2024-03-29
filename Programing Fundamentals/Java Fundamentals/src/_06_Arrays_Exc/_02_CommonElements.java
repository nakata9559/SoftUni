package _06_Arrays_Exc;

import java.util.Scanner;

public class _02_CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrayOne = scanner.nextLine().split(" ");

        String[] arrayTwo = scanner.nextLine().split(" ");

        for (String s2 : arrayTwo) {
            for (String s1 : arrayOne) {
                if (s1.equals(s2)) {
                    System.out.printf("%s ", s1);
                }
            }
        }
    }
}
