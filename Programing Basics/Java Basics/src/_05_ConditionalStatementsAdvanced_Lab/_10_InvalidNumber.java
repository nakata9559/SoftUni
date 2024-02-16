package _05_ConditionalStatementsAdvanced_Lab;

import java.util.Scanner;

public class _10_InvalidNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        boolean isValid = (number == 0 || (number <= 200 && number >= 100));

        if (!isValid) {
            System.out.println("invalid");
        }
    }
}
