package _00_MoreExercises._02_DataTypesAndVariables_MoreExc;

import java.util.Scanner;

public class _01_DataTypeFinder_UsingRegex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                System.out.printf("%s is boolean type%n", input);

            } else if (input.matches("\\D")) {
                System.out.printf("%s is character type%n", input);

            } else if (input.matches("\\d+") || input.matches("-\\d+")){
                System.out.printf("%s is integer type%n", input);

            } else if (input.matches("\\d*[.]\\d+") || input.matches("-\\d*[.]\\d+")) {
                System.out.printf("%s is floating point type%n", input);

            } else {
                System.out.printf("%s is string type%n", input);
            }

            input = scanner.nextLine();
        }
    }
}
