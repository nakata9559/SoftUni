package _08_Methods_Exc;

import java.util.Scanner;

public class _02_VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        countVowels(input);
    }

    public static void countVowels(String input) {
        int sumOfVowels = 0;

        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case 'a':
                case 'A':
                case 'e':
                case 'E':
                case 'o':
                case 'O':
                case 'u':
                case 'U':
                case 'i':
                case 'I':
                    sumOfVowels++;
                    break;
            }
        }
        System.out.println(sumOfVowels);
    }
}
