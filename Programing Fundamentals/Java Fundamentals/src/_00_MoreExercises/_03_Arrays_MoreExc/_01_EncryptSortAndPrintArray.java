package _00_MoreExercises._03_Arrays_MoreExc;

import java.util.Arrays;
import java.util.Scanner;

public class _01_EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfNames = Integer.parseInt(scanner.nextLine());

        int[] sumOfCodes = new int[numOfNames];

        for (int i = 0; i < numOfNames; i++) {

            String input = scanner.nextLine();

            for (int j = 0; j < input.length(); j++) {

                switch (input.charAt(j)) {
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
                        sumOfCodes[i] += input.charAt(j) * input.length();
                        break;

                    default:
                        sumOfCodes[i] += input.charAt(j) / input.length();
                        break;
                }
            }
        }

        for (int i = 0; i < sumOfCodes.length; i++) {

            for (int j = i + 1; j < sumOfCodes.length; j++) {

                if (sumOfCodes[i] > sumOfCodes[j]) {
                    int temp = sumOfCodes[i];
                    sumOfCodes[i] = sumOfCodes[j];
                    sumOfCodes[j] = temp;
                }
            }
        }

        System.out.println(String
                .join("\n", Arrays.stream(sumOfCodes)
                        .mapToObj(String::valueOf)
                        .toArray(String[]::new)));
    }
}
