package _14_MapsLambdaStreamAPI_Exc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _01_CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().replaceAll(" ", "");

        LinkedHashMap<String, Integer> countChars = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); i++) {
            if (!countChars.containsKey(String.valueOf(input.charAt(i)))) {
                countChars.put(String.valueOf(input.charAt(i)), 1);
            } else {
                countChars.put(String.valueOf(input.charAt(i)),
                        countChars.get(String.valueOf(input.charAt(i))) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : countChars.entrySet()) {
            System.out.printf("%s -> %d%n",
                    entry.getKey(),
                    entry.getValue());

        }
    }
}
