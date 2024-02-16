package _09_Lists_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _04_ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(
                scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<String> command = Arrays.stream(
                scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        while (!command.get(0).equals("end")) {
            switch (command.get(0)){
                case "Add":
                    numbers.add(Integer.parseInt(command.get(1)));
                    break;
                case "Remove":
                    numbers.remove(Integer.valueOf(command.get(1)));
                    break;
                case "RemoveAt":
                    numbers.remove(Integer.parseInt(command.get(1)));
                    break;
                case "Insert":
                    numbers.add(Integer.parseInt(command.get(2)), Integer.parseInt(command.get(1)));
                    break;
            }
            command = Arrays.stream(
                    scanner.nextLine().split(" "))
                    .collect(Collectors.toList());
        }

        System.out.println(String
                .join(" ", numbers.stream()
                        .map(String::valueOf)
                .collect(Collectors.toList())));
    }
}
