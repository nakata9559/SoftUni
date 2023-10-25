package _10_Lists_Exc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _04_ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers =
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<String> command =
                Arrays.stream(scanner.nextLine().split(" "))
                        .collect(Collectors.toList());

        while (!command.get(0).equals("End")) {
            switch (command.get(0)) {
                case "Add":
                    numbers.add(Integer.parseInt(command.get(1)));
                    break;

                case "Insert":
                    if (Integer.parseInt(command.get(2)) <= numbers.size() - 1 && Integer.parseInt(command.get(2)) >= 0) {
                        numbers.add(Integer.parseInt(command.get(2)),
                                Integer.parseInt(command.get(1)));
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;

                case "Remove":
                    if (Integer.parseInt(command.get(1)) <= numbers.size() - 1 && Integer.parseInt(command.get(1)) >= 0) {
                        numbers.remove(Integer.parseInt(command.get(1)));
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;

                case "Shift":
                    for (int i = 0; i < Integer.parseInt(command.get(2)); i++) {
                        switch (command.get(1)) {
                            case "left":
                                numbers.add(numbers.get(0));
                                numbers.remove(0);
                                break;

                            case "right":
                                numbers.add(0, numbers.get(numbers.size() - 1));
                                numbers.remove(numbers.size() - 1);
                                break;
                        }
                    }
                    break;
            }

            command = Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .collect(Collectors.toList());
        }
        System.out.println(String.join(" ", numbers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.toList())));
    }
}
