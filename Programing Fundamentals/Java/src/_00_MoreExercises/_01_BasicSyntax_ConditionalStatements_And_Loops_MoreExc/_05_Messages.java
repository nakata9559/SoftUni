package _00_MoreExercises._01_BasicSyntax_ConditionalStatements_And_Loops_MoreExc;

import java.util.Scanner;

public class _05_Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfPresses = Integer.parseInt(scanner.nextLine());;

        String message = "";

        for (int i = 0; i < numOfPresses; i++) {
            String inputString = scanner.nextLine();

            if (inputString.equals("0")) {
                message += " ";
                continue;
            }

            //	Find the number of digits the number has "e.g. 222 -> 3 digits"
            int numOfDigits = inputString.length();

            //	Find the main digit of the number "e.g.  222 -> 2"
            int mainDigit = Integer.parseInt(String.valueOf(inputString.charAt(0)));

            //	Find the offset of the number. To do that, you can use the formula: (main digit - 2) * 3
            int offsetNum = (mainDigit - 2) * 3;

            //	If the main digit is 8 or 9, we need to add 1 to the offset since the digits 7 and 9 have 4 letters each
            if (mainDigit == 8 || mainDigit == 9) {
                offsetNum++;
            }

            //	Finally, find the letter index (a -> 0, c -> 2, etc.). To do that, we can use the following formula: (offset + digit length - 1).
            int letterIndex = (offsetNum + numOfDigits - 1) + 97;

            //	After we've found the letter index, we can just add that to the ASCII code of the lowercase letter "a" (97)
            String currentLetter = Character.toString(letterIndex);

            message += currentLetter;
        }
        System.out.println(message);
    }
}
