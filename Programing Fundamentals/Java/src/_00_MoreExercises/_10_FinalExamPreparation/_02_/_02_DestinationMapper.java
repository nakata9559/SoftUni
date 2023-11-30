package _00_MoreExercises._10_FinalExamPreparation._02_;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("([=/])(?<destination>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(scanner.nextLine());

        int travelPoints = 0;
        List<String> destinations = new ArrayList<>();

        while (matcher.find()) {
            destinations.add(matcher.group("destination"));
            travelPoints += matcher.group("destination").length();
        }

        System.out.printf("Destinations: %s%n" +
                "Travel Points: %d%n",
                String.join(", ", destinations),
                travelPoints);
    }
}
