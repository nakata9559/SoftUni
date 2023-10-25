package _00_MoreExercises._03_Arrays_MoreExc;

import java.util.Arrays;
import java.util.Scanner;

public class _05_KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sampleLength = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int sampleCounter = 0;
        int[] bestSampleArray = new int[sampleLength];
        int bestSequenceSum = 0;
        int bestSampleNumber = 0;
        int bestStartingIndex = 0;
        int bestSequence = Integer.MIN_VALUE;
        while (!input.equals("Clone them!"))
        {
            sampleCounter++;
            int[] sequenceArray = Arrays.stream(input.split("!+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int sequenceCounter = 0;
            int currentBestSequenceCounter = 0;
            int sequenceStart = 0;
            int currentBestStartingIndex = 0;
            int currentSum = 0;
            for (int i = 0; i < sequenceArray.length; i++)
            {
                if (sequenceArray[i] == 1)
                {
                    if (sequenceCounter == 0)
                    {
                        sequenceStart = i;
                    }
                    currentSum++;
                    sequenceCounter++;
                }
                if (sequenceArray[i] == 0 || i == sequenceArray.length - 1)
                {
                    if (currentBestSequenceCounter < sequenceCounter)
                    {
                        currentBestStartingIndex = sequenceStart;
                        currentBestSequenceCounter = sequenceCounter;
                    }
                    sequenceCounter = 0;
                }
            }
            if (currentBestSequenceCounter > bestSequence
                    || (currentBestSequenceCounter == bestSequence && currentBestStartingIndex < bestStartingIndex)
                    || (currentBestSequenceCounter == bestSequence && currentBestStartingIndex == bestStartingIndex && currentSum > bestSequenceSum)
            )
            {
                bestSequence = currentBestSequenceCounter;
                bestSampleNumber = sampleCounter;
                bestSequenceSum = currentSum;
                bestStartingIndex = currentBestStartingIndex; ;
                bestSampleArray = sequenceArray;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", bestSampleNumber, bestSequenceSum);
        System.out.println(String.join(" ", Arrays.stream(bestSampleArray)
                .mapToObj(String::valueOf)
                .toArray(String[]::new)));
    }
}
