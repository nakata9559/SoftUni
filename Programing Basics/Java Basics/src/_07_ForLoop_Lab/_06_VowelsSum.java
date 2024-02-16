package _07_ForLoop_Lab;

import java.util.Scanner;

public class _06_VowelsSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        int sum = 0;

        for (int length = 0; length <= word.length() - 1; length++){
            switch (word.charAt(length)) {
                case 'a':
                case 'A':
                    sum += 1;
                    break;
                case 'e':
                case 'E':
                    sum += 2;
                    break;
                case 'i':
                case 'I':
                    sum += 3;
                    break;
                case 'o':
                case 'O':
                    sum += 4;
                    break;
                case 'u':
                case 'U':
                    sum += 5;
                    break;
            }
        }
        System.out.println(sum);
    }
}
