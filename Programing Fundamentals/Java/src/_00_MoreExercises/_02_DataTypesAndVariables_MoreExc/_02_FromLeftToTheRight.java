package _00_MoreExercises._02_DataTypesAndVariables_MoreExc;

import java.util.Scanner;

public class _02_FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfStrings = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfStrings; i++) {
            String input =  scanner.nextLine();
            int sumOfLeftDigits = 0;
            String numOfLeftDigits = "";
            int sumOfRightDigits = 0;
            String numOfRightDigits = "";
            boolean checkLeftDigits = true;

            for (int j = 0; j < input.length(); j++) {
                if (String.valueOf(input.charAt(j)).equals("-") && checkLeftDigits) {
                    numOfLeftDigits += String.valueOf(input.charAt(j));
                    continue;
                } else if (String.valueOf(input.charAt(j)).equals("-") && !checkLeftDigits) {
                    numOfRightDigits += String.valueOf(input.charAt(j));
                    continue;
                }

                if (String.valueOf(input.charAt(j)).equals(" ")) {
                    checkLeftDigits = false;
                    continue;
                }

                if (checkLeftDigits) {
                    sumOfLeftDigits += Integer.parseInt(String.valueOf(input.charAt(j)));
                    numOfLeftDigits += String.valueOf(input.charAt(j));
                } else {
                    sumOfRightDigits += Integer.parseInt(String.valueOf(input.charAt(j)));
                    numOfRightDigits += String.valueOf(input.charAt(j));
                }
            }
            if (Long.parseLong(numOfLeftDigits) > Long.parseLong(numOfRightDigits)) {
                System.out.println(sumOfLeftDigits);
            } else {
                System.out.println(sumOfRightDigits);
            }
        }
    }
}
