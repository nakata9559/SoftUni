package _03_DataTypesAndVariables_Lab;

import java.util.Scanner;

public class _10_SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int range = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= range; i++) {
            int sumOfDigits = 0;

            for (int j = 0; j < String.valueOf(i).length(); j++) {
                sumOfDigits += Integer.parseInt(String.valueOf(String.valueOf(i).charAt(j)));
            }

            if (sumOfDigits == 5 || sumOfDigits == 7 || sumOfDigits == 11) {
                System.out.printf("%d -> True%n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }
        }
    }
}
