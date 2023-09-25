package _00_MoreExercises._02_DataTypesAndVariables_MoreExc;

import java.util.Scanner;

public class _06_BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int interval = Integer.parseInt(scanner.nextLine());
        boolean isBalanced = false;
        String checkBrackets = "";

        for (int i = 0; i < interval; i++) {
            String input = scanner.nextLine();

            for (int j = 0; j < input.length(); j++) {
                char eachCharacter = input.charAt(j);

                if (eachCharacter == '(' || eachCharacter == ')') {
                    checkBrackets += eachCharacter;

                    if (checkBrackets.equals("()")) {
                        isBalanced = true;
                        checkBrackets = "";

                    } else if (checkBrackets.equals("))")) {
                        checkBrackets = "";

                    } else if (checkBrackets.equals("((")
                            || checkBrackets.equals("(")
                            || checkBrackets.equals(")")) {
                        isBalanced = false;
                        break;
                    }
                }
            }
        }

        if (isBalanced) {
            System.out.println("BALANCED");

        } else {
            System.out.println("UNBALANCED");
        }
    }
}
