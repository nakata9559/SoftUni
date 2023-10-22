package _10_Lists_Exc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _06_CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> playerOne =
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer> playerTwo =
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        while (playerOne.size() > 0 && playerTwo.size() > 0) {
            if (playerOne.get(0) > playerTwo.get(0)) {
                playerOne.add(playerOne.get(0));
                playerOne.add(playerTwo.get(0));
                playerOne.remove(0);
                playerTwo.remove(0);

            } else if (playerOne.get(0) < playerTwo.get(0)) {
                playerTwo.add(playerTwo.get(0));
                playerTwo.add(playerOne.get(0));
                playerOne.remove(0);
                playerTwo.remove(0);

            } else {
                playerOne.remove(0);
                playerTwo.remove(0);
            }
        }
        if (playerOne.size() > playerTwo.size()) {
            int sum = 0;

            for (int i = 0; i < playerOne.size(); i++) {
                sum += playerOne.get(i);
            }
            System.out.println("First player wins! Sum: " + sum);

        } else {
            int sum = 0;

            for (int i = 0; i < playerTwo.size(); i++) {
                sum += playerTwo.get(i);
            }
            System.out.println("Second player wins! Sum: " + sum);
        }
    }
}
