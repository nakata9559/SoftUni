package _06_SetsAndMapsAdvanced_Exc;

import java.util.*;

public class _04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> letters = new HashMap<>();

        String input = scanner.nextLine();

        for (char eachChar: input.toCharArray()){
            letters.putIfAbsent(eachChar, 0);
            letters.put(eachChar, letters.get(eachChar) + 1);
        }

        Map<Character, Integer> sortedLetters = new LinkedHashMap<>();

        letters.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(e -> sortedLetters.put(e.getKey(), e.getValue()));

        sortedLetters.forEach((k, v) -> {
            System.out.printf("%c: %d time/s%n", k, v);
        });
    }
}
