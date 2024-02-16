package _10_RegularMidExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_TheAngryCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> priceRatings =
                Arrays.stream(scanner.nextLine().split(", "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        int entryPoint = Integer.parseInt(scanner.nextLine());
        String itemsType = scanner.nextLine();

        List<Integer> itemsBrokenToTheLeft = new ArrayList<>();
        List<Integer> itemsBrokenToTheRight = new ArrayList<>();

        boolean cheap = true;

        if (itemsType.equals("expensive")) {
            cheap = false;
        }

        for (int i = 0; i <= entryPoint - 1; i++) {
            if (cheap) {
                if (priceRatings.get(i) < priceRatings.get(entryPoint)) {
                    itemsBrokenToTheLeft.add(priceRatings.get(i));
                }

            } else {
                if (priceRatings.get(i) >= priceRatings.get(entryPoint)) {
                    itemsBrokenToTheLeft.add(priceRatings.get(i));
                }
            }
        }

        for (int i = entryPoint + 1; i <= priceRatings.size() - 1; i++) {
            if (i > priceRatings.size() - 1) {
                break;
            }

            if (cheap) {
                if (priceRatings.get(i) < priceRatings.get(entryPoint)) {
                    itemsBrokenToTheRight.add(priceRatings.get(i));
                }

            } else {
                if (priceRatings.get(i) >= priceRatings.get(entryPoint)) {
                    itemsBrokenToTheRight.add(priceRatings.get(i));
                }
            }
        }
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;

        for (int i = 0; i < itemsBrokenToTheLeft.size(); i++) {
            if (i == 0) {
                leftSum = 0;
            }
            leftSum += itemsBrokenToTheLeft.get(i);
        }

        for (int i = 0; i < itemsBrokenToTheRight.size(); i++) {
            if (i == 0) {
                rightSum = 0;
            }
            rightSum += itemsBrokenToTheRight.get(i);
        }

        if (rightSum > leftSum) {
            System.out.println("Right - " + rightSum);
        } else {
            if (itemsBrokenToTheLeft.size() > 0) {
                System.out.println("Left - " + leftSum);
            } else {
                System.out.println("Left - " + 0);
            }
        }
    }
}
