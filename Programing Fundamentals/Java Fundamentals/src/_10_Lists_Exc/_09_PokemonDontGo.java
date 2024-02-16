package _10_Lists_Exc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _09_PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> elements =
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        int sum = 0;

        while (elements.size() > 0) {
            int givenIndex = Integer.parseInt(scanner.nextLine());
            int removedElement;

            if (givenIndex < 0) {
                removedElement = elements.get(0);
                sum += elements.get(0);
                elements.set(0, elements.get(elements.size() - 1));
                increaseOrDecreaseValue(elements, removedElement);

            } else if (givenIndex >= elements.size()) {
                removedElement = elements.get(elements.size() - 1);
                sum += elements.get(elements.size() - 1);
                elements.set(elements.size() - 1, elements.get(0));
                increaseOrDecreaseValue(elements, removedElement);

            } else {
                removedElement = elements.get(givenIndex);
                sum += elements.get(givenIndex);
                elements.remove(givenIndex);
                increaseOrDecreaseValue(elements, removedElement);
            }
        }

        System.out.println(sum);
    }

    public static void increaseOrDecreaseValue(List<Integer> elements, int removedElement) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) <= removedElement) {
                elements.set(i, elements.get(i) + removedElement);

            } else {
                elements.set(i, elements.get(i) - removedElement);
            }
        }
    }
}
