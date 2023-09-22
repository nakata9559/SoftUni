package _12_NestedLoops_Exc;

import java.util.Scanner;

public class _03_SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        int sumPrime = 0;
        int sumNonPrime = 0;
        boolean isNonPrime = false;

        while (!command.equals("stop")) {

            int value = Integer.parseInt(command);

            if (value < 0) {
                System.out.println("Number is negative.");
                command = scanner.nextLine();
                continue;
            }

            for (int divisor = 2; divisor < value; divisor++) {

                for (int check = 2; check < value; check++) {

                    if (1.0 * value / divisor == check) {
                        isNonPrime = true;
                        break;
                    }
                }
            }

            if (isNonPrime) {
                sumNonPrime += value;
            } else {
                sumPrime += value;
            }

            isNonPrime = false;
            command = scanner.nextLine();
        }
        System.out.println("Sum of all prime numbers is: " + sumPrime);
        System.out.println("Sum of all non prime numbers is: " + sumNonPrime);
    }
}