package _13_MapsLambdaStreamAPI_Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _03_OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputStrings = Arrays.stream(scanner.nextLine().split(" "))
                .map(String::toLowerCase)
                .toArray(String[]::new);

        LinkedHashMap<String, Integer> stringOccurrences = new LinkedHashMap<>();

        for (String string : inputStrings) {

            if (stringOccurrences.containsKey(string)) {
                stringOccurrences.put(string, stringOccurrences.get(string) + 1);
            } else {
                stringOccurrences.putIfAbsent(string, 1);
            }
        }

        String[] result = stringOccurrences
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() % 2 != 0)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);

        System.out.println(String.join(", ", result));
    }
}
