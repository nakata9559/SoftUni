package _08_Methods_Exc;

import java.util.Scanner;

public class _10_TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printTopNumbers(Integer.parseInt(scanner.nextLine()));
    }

    public static void printTopNumbers(int number) {
        for (int i = 1; i <= number; i++) {
            boolean haveOddDigit = false;
            int sumOfDigits = 0;

            for (int j = 0; j < String.valueOf(i).length(); j++) {
                sumOfDigits += String.valueOf(i).charAt(j);

                if (String.valueOf(i).charAt(j) % 2 != 0) {
                    haveOddDigit = true;
                }
            }

            if (haveOddDigit && sumOfDigits % 8 == 0) {
                System.out.println(i);
            }
        }
    }
}
