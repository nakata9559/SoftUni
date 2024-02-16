package _06_Arrays_Exc;

import java.util.Arrays;
import java.util.Scanner;

public class _07_MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sequenceCount = 1;
        int[] sequenceNumbers = {numbers[numbers.length - 1]};
        int lastDigit = numbers[numbers.length - 1];
        int currentSequenceCount = 1;
        int[] currentSequenceNumbers = {numbers[numbers.length - 1]};

        for (int i = numbers.length - 2; i >= 0; i--) {

            if (numbers[i] == lastDigit) {

                currentSequenceCount++;
                currentSequenceNumbers = new int[currentSequenceCount];

                for (int j = 0; j < currentSequenceCount; j++) {
                    currentSequenceNumbers[j] = lastDigit;
                }

            } else {
                currentSequenceCount = 1;
            }

            if (sequenceCount <= currentSequenceCount){
                sequenceCount = currentSequenceCount;
                sequenceNumbers = currentSequenceNumbers;
            }

            lastDigit = numbers[i];

        }
        System.out.println(String.join(" ", Arrays.stream(sequenceNumbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new)));
    }
}
