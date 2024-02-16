package _12_NestedLoops_Exc;

import java.util.Scanner;

public class _05_SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        for (int specialNum = 1111; specialNum <= 9999; specialNum++) {

            String specialNumString = String.valueOf(specialNum);
            int specialCharacters = 0;
            String output = "";

            for (int charAt = 0; charAt < specialNumString.length(); charAt++) {

                char specialNumPositionChar = specialNumString.charAt(charAt);

                String specialNumStringChar = String.valueOf(specialNumPositionChar);

                int specialNumPosition = Integer.parseInt(specialNumStringChar);

                if (specialNumPosition != 0 && input % specialNumPosition == 0) {
                    output += specialNumStringChar;
                    specialCharacters++;
                }

                if (specialCharacters == 4) {
                    System.out.print(output + " ");
                }
            }
        }
    }
}
