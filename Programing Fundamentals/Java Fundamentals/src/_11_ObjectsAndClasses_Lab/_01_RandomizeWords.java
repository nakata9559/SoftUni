package _11_ObjectsAndClasses_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> words =
                Arrays.stream(scanner.nextLine().split(" "))
                        .collect(Collectors.toList());

        Random randomizer = new Random();

        for (int i = 0; i < words.size(); i++) {

            if (words.size() > 1) {

                int randomIndex = randomizer.nextInt(words.size() - 1);
                String buffer = words.get(i);
                words.set(i, words.get(randomIndex));
                words.set(randomIndex, buffer);

            }
        }

        System.out.println(String.join("\n", words.stream()
                .map(String::valueOf)
                .collect(Collectors.toList())));
    }
}
