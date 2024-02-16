package _12_ObjectsAndClasses_Exc;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class _01_AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> phrase = List.of(new String[]{
                "Excellent product.",
                "Such a great product.",
                "I always use that product.",
                "Best product of its category.",
                "Exceptional product.",
                "I can’t live without this product."});

        List<String> event = List.of(new String[]{
                "Now I feel good.",
                "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.",
                "I feel great!"});

        List<String> author = List.of(new String[]{
                "Diana",
                "Petya",
                "Stella",
                "Elena",
                "Katya",
                "Iva",
                "Annie",
                "Eva"});

        List<String> city = List.of(new String[]{
                "Burgas",
                "Sofia",
                "Plovdiv",
                "Varna",
                "Ruse"});

        Random randomizer = new Random();

        int numOfMessages = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfMessages; i++) {
            System.out.printf("%s %s %s - %s%n",
                    phrase.get(randomizer.nextInt(phrase.size() - 1)),
                    event.get(randomizer.nextInt(event.size() - 1)),
                    author.get(randomizer.nextInt(author.size() - 1)),
                    city.get(randomizer.nextInt(city.size() - 1)));
        }
    }
}
