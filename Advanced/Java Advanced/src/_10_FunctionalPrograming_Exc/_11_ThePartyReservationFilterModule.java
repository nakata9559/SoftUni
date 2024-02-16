package _10_FunctionalPrograming_Exc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _11_ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests =
                Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        List<String> actions = new ArrayList<>();

        while (!"Print".equals(input)) {
            String command = input.split(";")[0];
            String criteria = input.split(";")[1];
            String parameter = input.split(";")[2];

            switch (command) {
                case "Add filter":
                    actions.add(criteria + ";" + parameter);
                    break;
                case "Remove filter":
                    actions.remove(criteria + ";" + parameter);
                    break;
            }

            input = scanner.nextLine();
        }

        List<Predicate<String>> predicateList = new ArrayList<>();

        for (String action : actions) {
            String criteria = action.split(";")[0];
            String parameter = action.split(";")[1];

            switch (criteria) {
                case "Starts with":
                    predicateList.add(e -> !e.startsWith(parameter));
                    break;
                case "Ends with":
                    predicateList.add(e -> !e.endsWith(parameter));
                    break;
                case "Length":
                    predicateList.add(e -> e.length() != Integer.parseInt(parameter));
                    break;
                case "Contains":
                    predicateList.add(e -> !e.contains(parameter));
                    break;
            }
        }

        for (Predicate<String> predicate : predicateList){
            guests = guests.stream()
                    .filter(predicate)
                    .collect(Collectors.toList());
        }

        System.out.println(String.join(" ", guests));
    }
}
