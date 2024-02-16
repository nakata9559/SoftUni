package _09_FunctionalPrograming_Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public class _03_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> isUppercase = e -> Character.isUpperCase(e.charAt(0));

        String[] inputText = scanner.nextLine().split("\\s+");

        AtomicInteger numOfUppercaseWords = new AtomicInteger();

        Arrays.stream(inputText)
                .filter(isUppercase)
                .forEach(e -> numOfUppercaseWords.getAndIncrement());

        System.out.println(numOfUppercaseWords);

        Arrays.stream(inputText)
                .filter(isUppercase)
                .forEach(System.out::println);
    }
}
