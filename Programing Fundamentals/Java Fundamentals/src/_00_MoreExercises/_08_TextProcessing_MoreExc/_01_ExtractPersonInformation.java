package _00_MoreExercises._08_TextProcessing_MoreExc;

import java.util.Scanner;

public class _01_ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfLines; i++) {
            String input = scanner.nextLine();

            int nameFirstIndex = input.indexOf("@") + 1;
            int nameLastIndex = input.indexOf("|");
            int ageFirstIndex = input.indexOf("#") + 1;
            int ageLastIndex = input.indexOf("*");

            String name = input.substring(nameFirstIndex, nameLastIndex);
            String age = input.substring(ageFirstIndex, ageLastIndex);

            System.out.println(name + " is " + age + " years old.");
        }
    }
}
