package _01_BasicSyntax_ConditionalStatements_And_Loops_Lab;

import java.util.Scanner;

public class _08_DivisibleByThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 3; i < 100 ; i+=3) {
            System.out.println(i);
        }
    }
}
