package _03_DataTypesAndVariables_Lab;

import java.math.BigDecimal;
import java.util.Scanner;

public class _03_ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfNumbers = Integer.parseInt(scanner.nextLine());

        BigDecimal sum = new BigDecimal(0);

        for (int i = 0; i < numberOfNumbers; i++) {
            BigDecimal num = new BigDecimal(scanner.nextLine());
            sum = sum.add(num);
        }
        System.out.println(sum);
    }
}
