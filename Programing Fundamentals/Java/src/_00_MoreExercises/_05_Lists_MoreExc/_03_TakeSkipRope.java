package _00_MoreExercises._05_Lists_MoreExc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputList =
                Arrays.stream(scanner.nextLine().split(""))
                        .collect(Collectors.toList());

        List<String> numbersList = new ArrayList<>();
        List<String> nonNumbersList = new ArrayList<>();
        List<String> resultList = new ArrayList<>();

        for (int i = 0; i < inputList.size(); i++) {
            if (inputList.get(i).charAt(0) >= '0'
                    && inputList.get(i).charAt(0) <= '9') {
                numbersList.add(inputList.get(i));

            } else {
                nonNumbersList.add(inputList.get(i));
            }
        }

        int indexForward = 0;

        for (int i = 0; i < numbersList.size(); i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < Integer.parseInt(numbersList.get(i)); j++) {
                    resultList.add(nonNumbersList.get(j + indexForward));

                    if (indexForward + j >= nonNumbersList.size() - 1) {
                        break;
                    }
                }

                indexForward += Integer.parseInt(numbersList.get(i));

            } else {
                indexForward += Integer.parseInt(numbersList.get(i));

            }
        }

        System.out.println(String.join("", resultList));
    }
}
