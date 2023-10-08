package _00_MoreExercises._03_Arrays_MoreExc;

import java.util.Arrays;
import java.util.Scanner;

public class _05_KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sequencesLength = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        int sum = 0;
        int index = 0;
        String[] arrOutput = new String[sequencesLength];
        int currentIndex = 0;

        while (!input.equals("Clone them!")) {
            int currentSum = 0;
            currentIndex++;
            int dnaNumbers = Integer.parseInt(input.replaceAll("!", ""));

            String[] dnaCheck = String
                    .valueOf(dnaNumbers)
                    .split("");

            for (int i = 0; i < dnaCheck.length; i++) {
                currentSum += Integer.parseInt(dnaCheck[i]);
            }

            if (currentSum >= sum) {
                sum = currentSum;
                arrOutput = dnaCheck;
                index = currentIndex;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Best DNA smaple %d with sum: %d.%n", index, sum);
        System.out.println(String
                .join(" ", arrOutput));
    }
}
