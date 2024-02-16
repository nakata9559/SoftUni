package _08_Methods_Exc;

import java.util.Scanner;

public class _04_PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printPasswordState(scanner.nextLine());
    }

    public static void printPasswordState(String input) {
        boolean isValid = true;

        if (!checkRule1(input, isValid)) {
            isValid = false;
        }

        if (!checkRule2(input, isValid)) {
            isValid = false;
        }

        if (!checkRule3(input, isValid)) {
            isValid = false;
        }

        if (isValid) {
            System.out.println("Password is valid");
        }
    }

    public static boolean checkRule1(String input, boolean isValid) {
        if (input.length() < 6 || input.length() > 10) {
            System.out.println("Password must be between 6 and 10 characters");
            return false;
        }
        return true;
    }

    public static boolean checkRule2(String input, boolean isValid) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 'a'
                    && input.charAt(i) <= 'z'
                    || input.charAt(i) >= 'A'
                    && input.charAt(i) <= 'Z'
                    || input.charAt(i) >= '0'
                    && input.charAt(i) <= '9') {
            } else {
                System.out.println("Password must consist only of letters and digits");
                return false;
            }
        }

        return true;
    }

    public static boolean checkRule3(String input, boolean isValid) {
        int sumOfDigits = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= '0'
                    && input.charAt(i) <= '9') {

                sumOfDigits++;
            }
        }

        if (sumOfDigits < 2) {
            System.out.println("Password must have at least 2 digits");
            return false;
        }

        return true;
    }
}
