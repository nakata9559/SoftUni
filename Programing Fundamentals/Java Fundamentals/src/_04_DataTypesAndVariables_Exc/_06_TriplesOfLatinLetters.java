package _04_DataTypesAndVariables_Exc;

import java.util.Scanner;

public class _06_TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                for (int k = 0; k < input; k++) {
                    char lastLetter = (char) (97 + k);
                    char middleLetter = (char) (97 + j);
                    char firstLetter = (char) (97 + i);
                    System.out.printf("%c%c%c%n", firstLetter, middleLetter, lastLetter);
                }
            }
        }
    }
}
