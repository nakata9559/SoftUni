package _04_DataTypesAndVariables_Exc;

import java.util.Scanner;

public class _04_SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int range = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 0; i < range; i++) {
            sum += (char)scanner.nextLine().charAt(0);
        }

        System.out.println("The sum equals: " + sum);
    }
}
