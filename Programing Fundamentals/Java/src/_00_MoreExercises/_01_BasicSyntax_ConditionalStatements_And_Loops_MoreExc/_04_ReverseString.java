package _00_MoreExercises._01_BasicSyntax_ConditionalStatements_And_Loops_MoreExc;

import java.util.Scanner;

public class _04_ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String reverseInput = "";

        for (int i = input.length() -1; i >= 0; i--) {
            reverseInput += input.charAt(i);
        }
        System.out.println(reverseInput);
    }
}
