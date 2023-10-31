package _11_ObjectsAndClasses_Lab;

import java.math.BigInteger;
import java.util.Scanner;

public class _03_BigFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        BigInteger factorial = BigInteger.valueOf(1);

        for (int i = 1; i <= number; i++) {

            factorial = factorial.multiply(BigInteger.valueOf(i));

        }

        System.out.println(factorial);

    }
}
