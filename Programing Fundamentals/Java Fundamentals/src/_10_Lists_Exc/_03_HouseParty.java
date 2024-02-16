package _10_Lists_Exc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfCommands = Integer.parseInt(scanner.nextLine());

        List<String> guests = new ArrayList<>();

        for (int i = 0; i < numOfCommands; i++) {
            List<String> command =
                    Arrays.stream(scanner.nextLine().split(" "))
                            .collect(Collectors.toList());

            if (command.get(1).equals("is") && command.get(2).equals("going!")) {
                boolean isNotInTheList = true;
                for (int j = 0; j < guests.size(); j++) {
                    if (command.get(0).equals(guests.get(j))) {
                        isNotInTheList = false;
                        System.out.println(command.get(0) + " is already in the list!");
                        break;
                    }
                }
                if (isNotInTheList) {
                    guests.add(command.get(0));
                }

            } else if (command.get(1).equals("is") && command.get(2).equals("not") && command.get(3).equals("going!")){
                boolean isNotInTheList = true;

                for (int j = 0; j < guests.size(); j++) {
                    if (command.get(0).equals(guests.get(j))) {
                        isNotInTheList = false;
                        guests.remove(command.get(0));
                        break;
                    }
                }
                if (isNotInTheList) {
                    System.out.println(command.get(0) + " is not in the list!");
                }
            }
        }
        System.out.println(String.join(
                "\n", guests.stream()
                        .map(String::valueOf)
                        .collect(Collectors.toList())));
    }
}
