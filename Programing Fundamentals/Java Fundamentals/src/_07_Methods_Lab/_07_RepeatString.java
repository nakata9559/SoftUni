package _07_Methods_Lab;

import java.util.Scanner;

public class _07_RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();
        int numOfRepeats = Integer.parseInt(scanner.nextLine());

        System.out.println(outputString(inputString, numOfRepeats));
    }

    public static String outputString(String inputString, int numOfRepeats) {
        String result = "";
        for (int i = 0; i < numOfRepeats; i++) {
            result += inputString;
        }

        return result;
    }
}
