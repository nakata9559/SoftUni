package _06_SetsAndMapsAdvanced_Exc;

import java.util.*;

public class _02_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] setsLength = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Set<Integer> setOne = new LinkedHashSet<>();
        Set<Integer> setTwo = new LinkedHashSet<>();

        for (int i = 0; i < setsLength[0]; i++) {
            setOne.add(Integer.parseInt(scanner.nextLine()));
        }

        for (int i = 0; i < setsLength[1]; i++) {
            setTwo.add(Integer.parseInt(scanner.nextLine()));
        }

        setOne.forEach(v1 -> {
            setTwo.forEach(v2 -> {
                if (Objects.equals(v1, v2)) {
                    System.out.printf("%d ", v1);
                }
            });
        });

        System.out.println();
    }
}
