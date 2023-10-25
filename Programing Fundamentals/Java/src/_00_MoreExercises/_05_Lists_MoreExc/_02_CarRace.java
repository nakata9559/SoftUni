package _00_MoreExercises._05_Lists_MoreExc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> times =
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        double leftTime = 0;
        double rightTime = 0;

        for (int i = 0; i < times.size() / 2; i++) {
            if (times.get(i) == 0) {
                leftTime *= 0.8;
            } else {
                leftTime += times.get(i);
            }
        }

        for (int i = times.size() - 1; i > times.size() / 2; i--) {
            if (times.get(i) == 0) {
                rightTime *= 0.8;
            } else {
                rightTime += times.get(i);
            }
        }

        if (leftTime <= rightTime) {
            System.out.printf("The winner is left with total time: %.1f%n", leftTime);
        } else {
            System.out.printf("The winner is right with total time: %.1f%n", rightTime);
        }
    }
}
