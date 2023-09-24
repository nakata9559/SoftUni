package _04_DataTypesAndVariables_Exc;

import java.util.Scanner;

public class _05_PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startRange = Integer.parseInt(scanner.nextLine());
        int endRange = Integer.parseInt(scanner.nextLine());

        for (int i = startRange; i <= endRange; i++) {
            char index = (char)i;
            System.out.printf("%c ", index);
        }
    }
}
