package _10_FunctionalPrograming_Exc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _10_PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests =
                Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Predicate<String> predicate = s -> true;

        String input = scanner.nextLine();

        while (!"Party!".equals(input)) {
            String command = input.split("\\s+")[0];
            String criteria = input.split("\\s+")[1];
            String parameter = input.split("\\s+")[2];

            switch (criteria) {
                case "StartsWith":
                    predicate = s -> s.startsWith(parameter);
                    break;

                case "EndsWith":
                    predicate = s -> s.endsWith(parameter);
                    break;

                case "Length":
                    predicate = s -> s.length() == Integer.parseInt(parameter);
                    break;
            }

            switch (command) {
                case "Remove":
                    guests.removeIf(predicate);
                    break;

                case "Double":
                    List<String> guestsToAdd = guests.stream()
                            .filter(predicate)
                            .collect(Collectors.toList());

                    guests.addAll(guestsToAdd);
                    break;
            }

            input = scanner.nextLine();
        }

        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");

        } else {
            guests.sort(Comparator.naturalOrder());
            System.out.printf("%s are going to the party!%n",
                    String.join(", ", guests));
        }
    }
}
