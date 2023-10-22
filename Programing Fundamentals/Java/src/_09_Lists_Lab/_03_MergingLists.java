package _09_Lists_Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOne = new ArrayList<>(
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()));

        List<Integer> listTwo = new ArrayList<>(
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()));

        int indexListOne = 0;
        int indexListTwo = 0;

        boolean listOneTurn = true;

        while (indexListOne < listOne.size() && indexListTwo < listTwo.size()) {

            if (listOneTurn) {
                System.out.print(listOne.get(indexListOne) + " ");
                indexListOne++;
                listOneTurn = false;

            } else {
                System.out.print(listTwo.get(indexListTwo) + " ");
                indexListTwo++;
                listOneTurn = true;
            }
        }

        for (int i = indexListOne; i < listOne.size(); i++) {
            System.out.print(listOne.get(i) + " ");
        }

        for (int i = indexListTwo; i < listTwo.size(); i++) {
            System.out.print(listTwo.get(i) + " ");
        }
    }
}
