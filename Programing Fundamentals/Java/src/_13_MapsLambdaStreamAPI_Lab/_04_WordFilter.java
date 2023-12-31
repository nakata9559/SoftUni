package _13_MapsLambdaStreamAPI_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _04_WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = Arrays.stream(scanner.nextLine().split(" "))
                .filter(word -> word.length() % 2 == 0)
                .toArray(String[]::new);

        System.out.println(String.join("\n", words));
    }
}
