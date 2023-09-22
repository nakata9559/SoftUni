package _00_MoreExercises._01_BasicSyntax_ConditionalStatements_And_Loops_MoreExc;

import java.util.Scanner;

public class _02_EnglishNameOfTheLastDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        char lastDigit = String.valueOf(num).charAt(String.valueOf(num).length() - 1);
        String output = "";

        switch (lastDigit) {
            case '0':
                output = "zero";
                break;
            case '1':
                output = "one";
                break;
            case '2':
                output = "two";
                break;
            case '3':
                output = "three";
                break;
            case '4':
                output = "four";
                break;
            case '5':
                output = "five";
                break;
            case '6':
                output = "six";
                break;
            case '7':
                output = "seven";
                break;
            case '8':
                output = "eight";
                break;
            case '9':
                output = "nine";
                break;
        }
        System.out.println(output);
    }
}
