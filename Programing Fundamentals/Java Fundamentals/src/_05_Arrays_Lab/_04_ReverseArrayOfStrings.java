package _05_Arrays_Lab;

import java.util.Scanner;

public class _04_ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split(" ");

        for (int i = strings.length - 1; i >= 0; i--) {
            System.out.printf("%s ", strings[i]);
        }
    }
}
