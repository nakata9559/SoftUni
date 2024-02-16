package _10_Lists_Exc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> passengersInEachWagon =
                Arrays.stream(scanner.nextLine()
                        .split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());

        List<String> command =
                Arrays
                        .stream(scanner.nextLine().split(" "))
                        .collect(Collectors.toList());

        while (!command.get(0).equals("end")) {
            switch (command.get(0)) {
                case "Add":
                    passengersInEachWagon.add(Integer.parseInt(command.get(1)));
                    break;

                default:
                    for (int i = 0; i < passengersInEachWagon.size(); i++) {
                        if (passengersInEachWagon.get(i) + Integer.parseInt(command.get(0)) <= maxCapacity) {
                            passengersInEachWagon.set(i,
                                    passengersInEachWagon.get(i) + Integer.parseInt(command.get(0)));
                            break;
                        }
                    }
                    break;
            }
            command = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .collect(Collectors.toList());
        }
        System.out.println(String.join(
                " ", passengersInEachWagon.stream()
                .map(String::valueOf)
                .collect(Collectors.toList())));
    }
}
