package _02_BasicSyntax_ConditionalStatements_And_Loops_Exc;

import java.util.Scanner;

public class _05_Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstInput = scanner.nextLine();
        int tries = 0;

        String reversedInput = "";

        for (int i = firstInput.length() - 1; i >= 0; i--) {
            reversedInput += firstInput.charAt(i);
        }

        String secondInput = scanner.nextLine();

        while (!secondInput.equals(reversedInput)) {
            tries += 1;
            if (tries == 4) {
                break;
            }
            System.out.printf("Incorrect password. Try again.%n");
            secondInput = scanner.nextLine();
        }

        if (tries == 4) {
            System.out.printf("User %s blocked!%n", firstInput);
        } else {
            System.out.printf("User %s logged in.", firstInput);
        }
    }
}
