package _08_Methods_Exc;

import java.util.Scanner;

public class _01_SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(printSmallestNum(Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine())));
    }

    public static int printSmallestNum(int num1, int num2, int num3) {
        if (num1 < num2 && num1 < num3) {
            return num1;

        } else if (num2 < num1 && num2 < num3) {
            return num2;
        }

        return num3;
    }
}
