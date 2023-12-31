package _07_Methods_Lab;

import java.util.Scanner;

public class _09_GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();

        switch (type) {
            case "int":
                System.out.println(getMax(Integer.parseInt(scanner.nextLine()),
                        Integer.parseInt(scanner.nextLine())));
                break;

            case "char":
                System.out.println(getMax(scanner.nextLine().charAt(0),
                        scanner.nextLine().charAt(0)));
                break;

            case "string":
                System.out.println(getMax(scanner.nextLine(),
                        scanner.nextLine()));
                break;
        }
    }

    public static int getMax(int firstNum, int secondNum) {
        if (firstNum > secondNum) {
            return firstNum;
        }

        return secondNum;
    }

    public static char getMax(char firstChar, char secondChar) {
        if (firstChar > secondChar) {
            return firstChar;
        }

        return secondChar;
    }

    public static String getMax(String firstString, String secondString) {
        if (firstString.compareTo(secondString) >= 0) {
            return firstString;
        }

        return secondString;
    }
}
