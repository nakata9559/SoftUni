package _05_SetsAndMapsAdvanced_Lab;

import java.util.*;

public class _03_Voina_NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayerNums = new LinkedHashSet<>();
        Set<Integer> secondPlayerNums = new LinkedHashSet<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(firstPlayerNums::add);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(secondPlayerNums::add);

        for (int i = 0; i < 50; i++) {
            Iterator<Integer> firstPlayer = firstPlayerNums.iterator();
            Iterator<Integer> secondPlayer = secondPlayerNums.iterator();
            int firstPlayerCurrentNum = firstPlayer.next();
            firstPlayerNums.remove(firstPlayerCurrentNum);
            int secondPlayerCurrentNum = secondPlayer.next();
            secondPlayerNums.remove(secondPlayerCurrentNum);

            if (firstPlayerCurrentNum > secondPlayerCurrentNum) {
                firstPlayerNums.add(firstPlayerCurrentNum);
                firstPlayerNums.add(secondPlayerCurrentNum);
            } else if (firstPlayerCurrentNum < secondPlayerCurrentNum) {
                secondPlayerNums.add(firstPlayerCurrentNum);
                secondPlayerNums.add(secondPlayerCurrentNum);
            } else {
                firstPlayerNums.add(firstPlayerCurrentNum);
                secondPlayerNums.add(secondPlayerCurrentNum);
            }

            if (firstPlayerNums.isEmpty() || secondPlayerNums.isEmpty()) break;
        }

        if (firstPlayerNums.size() > secondPlayerNums.size()) {
            System.out.println("First player win!");
        } else if (firstPlayerNums.size() < secondPlayerNums.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
