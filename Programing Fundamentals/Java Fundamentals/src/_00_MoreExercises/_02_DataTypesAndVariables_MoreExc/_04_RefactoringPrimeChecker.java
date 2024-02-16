package _00_MoreExercises._02_DataTypesAndVariables_MoreExc;

import java.util.Scanner;

public class _04_RefactoringPrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lastNumber = Integer.parseInt(scanner.nextLine());
        for (int firstNumber = 2; firstNumber <= lastNumber; firstNumber++) {
            boolean isPrime = true;

            for (int divisor = 2; divisor < firstNumber; divisor++) {
                if (firstNumber % divisor == 0) {
                    isPrime = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", firstNumber, isPrime);
        }
    }
}
