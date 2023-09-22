package _02_BasicSyntax_ConditionalStatements_And_Loops_Exc;

import java.util.Scanner;

public class _06_StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        String inputString = String.valueOf(input);

        int factSum = 0;

        for (int i = 0; i <= inputString.length() - 1; i++) {
            int eachNum = Integer.parseInt(String.valueOf(inputString.charAt(i)));
            int factEach = 1;

            for (int j = 1; j <= eachNum; j++) {
                factEach *= j;
            }
            factSum += factEach;
        }
        if (factSum == input) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
