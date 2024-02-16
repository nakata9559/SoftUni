package _04_DataTypesAndVariables_Exc;

import java.util.Scanner;

public class _02_SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        int eachNum = input;
        int sum = 0;

        for (int i = 0; i < String.valueOf(input).length(); i++) {
            sum += eachNum % 10;
            eachNum /= 10;
        }

        System.out.println(sum);
    }
}
