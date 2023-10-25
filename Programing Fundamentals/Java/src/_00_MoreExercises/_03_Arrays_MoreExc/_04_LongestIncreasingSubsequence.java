package _00_MoreExercises._03_Arrays_MoreExc;

import java.util.Arrays;
import java.util.Scanner;

public class _04_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sequence =
                Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int[] lis;
        int[] len = new int[sequence.length];
        int[] prev = new int[sequence.length];
        int maxLength = 0;
        int lastIndex = -1;

        for (int i = 0; i < sequence.length; i++)
        {
            len[i] = 1;
            prev[i] = -1;

            for (int j = 0; j < i; j++)
            {
                if (sequence[j] < sequence[i] && len[j] >= len[i])
                {
                    len[i] = 1 + len[j];
                    prev[i] = j;
                }
            }
            if (len[i] > maxLength)
            {
                maxLength = len[i];
                lastIndex = i;
            }
        }
        lis = new int[maxLength];
        for (int i = maxLength - 1; i >= 0; i--)
        {
            lis[i] = sequence[lastIndex];
            lastIndex = prev[lastIndex];
        }

        System.out.println(String.join(" ", Arrays.stream(lis)
                .mapToObj(String::valueOf)
                .toArray(String[]::new)));
    }
}
