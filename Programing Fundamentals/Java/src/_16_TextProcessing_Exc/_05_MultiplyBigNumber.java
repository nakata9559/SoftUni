package _16_TextProcessing_Exc;

import java.util.Scanner;

public class _05_MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder numberAsString = new StringBuilder(String.valueOf(scanner.nextLine())).reverse();
        int multiplier = Integer.parseInt(scanner.nextLine());
        
        StringBuilder outputNumber = new StringBuilder();
        StringBuilder currentPart = new StringBuilder();
        String extraNum = "0";

        for (int i = 0; i < numberAsString.length(); i++) {
            currentPart.append(numberAsString, i, i + 1).reverse();

            int currentPartNum = Integer.parseInt(String.valueOf(currentPart)) * multiplier + Integer.parseInt(extraNum);
            StringBuilder currentString = new StringBuilder();
            currentString.append(currentPartNum).reverse();

            if (currentString.length() < 2
            || i == numberAsString.length() - 1){
                extraNum = "0";
                outputNumber.append(currentString);

            } else {
                extraNum = currentString.substring(1);
                outputNumber.append(currentString.substring(0, 1));
            }

            currentPart.setLength(0);
        }
        outputNumber.reverse();

        if (outputNumber.toString().equals("0")) {
            System.out.println(outputNumber);
            return;
        }
        String currentDigit = outputNumber.substring(0, 1);

        while (currentDigit.equals("0") && outputNumber.length() > 1) {
            outputNumber = new StringBuilder(outputNumber.substring(1));
            currentDigit = outputNumber.substring(0, 1);
        }

        System.out.println(outputNumber);
    }
}
