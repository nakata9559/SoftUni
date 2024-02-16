package _00_MoreExercises._02_DataTypesAndVariables_MoreExc;

import java.util.Scanner;

public class _05_DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int numberOfLetters = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfLetters; i++) {
            String eachLetter = scanner.nextLine();
            char message = (char) (eachLetter.charAt(0) + key);
            System.out.printf("%c", message);
        }
    }
}
