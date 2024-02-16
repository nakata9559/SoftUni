package _03_DataTypesAndVariables_Lab;

import java.util.Scanner;

public class _05_ConcatNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        String delimiter = scanner.nextLine();

        System.out.println(firstName + delimiter + lastName);
    }
}
