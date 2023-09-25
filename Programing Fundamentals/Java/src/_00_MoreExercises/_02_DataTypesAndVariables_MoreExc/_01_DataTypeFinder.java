package _00_MoreExercises._02_DataTypesAndVariables_MoreExc;

import java.util.Scanner;

public class _01_DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            boolean isString = false;
            boolean isInteger = false;
            boolean isFloatingPoint = false;

            if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                System.out.printf("%s is boolean type%n", input);
                input = scanner.nextLine();
                continue;

            } else if (input.length() == 1
                    && input.charAt(0) != '0'
                    && input.charAt(0) != '1'
                    && input.charAt(0) != '2'
                    && input.charAt(0) != '3'
                    && input.charAt(0) != '4'
                    && input.charAt(0) != '5'
                    && input.charAt(0) != '6'
                    && input.charAt(0) != '7'
                    && input.charAt(0) != '8'
                    && input.charAt(0) != '9') {
                System.out.printf("%s is character type%n", input);
                input = scanner.nextLine();
                continue;

            } else {
                for (int i = 0; i < input.length(); i++) {
                    char eachCharacter = input.charAt(i);

                    if (eachCharacter == '0'
                            || eachCharacter == '1'
                            || eachCharacter == '2'
                            || eachCharacter == '3'
                            || eachCharacter == '4'
                            || eachCharacter == '5'
                            || eachCharacter == '6'
                            || eachCharacter == '7'
                            || eachCharacter == '8'
                            || eachCharacter == '9'
                            || eachCharacter == '-'
                            || eachCharacter == '.') {

                        if (isInteger && eachCharacter == '-') {
                            isString = true;
                            break;

                        } else if (isFloatingPoint && eachCharacter == '.') {
                            isString = true;
                            break;

                        }

                        if (eachCharacter != '.') {
                            isInteger = true;

                        } else {
                            isFloatingPoint = true;
                            isInteger = false;
                        }

                    } else {
                        isString = true;
                        break;
                    }
                }

                if (isString) {
                    System.out.printf("%s is string type%n", input);
                } else if (isFloatingPoint) {
                    System.out.printf("%s is floating point type%n", input);
                } else if (isInteger) {
                    System.out.printf("%s is integer type%n", input);
                }
            }
            input = scanner.nextLine();
        }
    }
}
