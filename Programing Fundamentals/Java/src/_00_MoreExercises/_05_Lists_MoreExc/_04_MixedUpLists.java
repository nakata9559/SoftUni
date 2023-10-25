package _00_MoreExercises._05_Lists_MoreExc;

import java.util.*;
import java.util.stream.Collectors;

public class _04_MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList =
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer> secondList =
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        List<Integer> range = new ArrayList<>();

        if (firstList.size() > secondList.size()) {
            range.add(firstList.get(firstList.size() - 1));
            range.add(firstList.get(firstList.size() - 2));
            Collections.sort(range);

            for (int i = 0; i < firstList.size() - 2; i++) {
                if (firstList.get(i) > range.get(0)
                        && firstList.get(i) < range.get(1)) {
                    result.add(firstList.get(i));
                }
            }

            for (int i = 0; i < secondList.size(); i++) {

                if (secondList.get(secondList.size() - 1 - i) > range.get(0)
                        && secondList.get(secondList.size() - 1 - i) < range.get(1)) {
                    result.add(secondList.get(secondList.size() - 1 - i));
                }
            }


        } else {
            range.add(secondList.get(0));
            range.add(secondList.get(1));
            Collections.sort(range);

            for (int i = 0; i < firstList.size(); i++) {
                if (firstList.get(i) > range.get(0)
                        && firstList.get(i) < range.get(1)) {
                    result.add(firstList.get(i));
                }

            }

            for (int i = 2; i < secondList.size(); i++) {

                if (secondList.get(secondList.size() + 1 - i) > range.get(0)
                        && secondList.get(secondList.size() + 1 - i) < range.get(1)) {
                    result.add(secondList.get(secondList.size() + 1 - i));

                }

            }
        }

        Collections.sort(result);

        System.out.println(String.join(" ", result.stream()
                .map(String::valueOf)
                .collect(Collectors.toList())));
    }
}
