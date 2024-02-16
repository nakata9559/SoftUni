package _05_Arrays_Lab;

import java.util.Scanner;

public class _02_PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfNumbers = Integer.parseInt(scanner.nextLine());

        int[] numbersArray = new int[numberOfNumbers];

        for (int i = 0; i < numberOfNumbers; i++) {
            numbersArray[i] = Integer.parseInt(scanner.nextLine());
        }

        for (int i = numbersArray.length - 1; i >= 0; i--) {
            System.out.printf("%d ", numbersArray[i]);
        }
    }
}
