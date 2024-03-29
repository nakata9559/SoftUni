package _10_RegularMidExam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_CoffeeLover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> coffees =
                Arrays.stream(scanner.nextLine().split(" "))
                        .collect(Collectors.toList());

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            List<String> command =
                    Arrays.stream(scanner.nextLine().split(" "))
                            .collect(Collectors.toList());

            switch (command.get(0)) {
                case "Include":
                    coffees.add(command.get(1));
                    break;

                case "Remove":
                    if (Integer.parseInt(command.get(2)) <= coffees.size()){
                        switch (command.get(1)) {
                            case "first":
                                for (int j = 0; j < Integer.parseInt(command.get(2)); j++) {
                                    coffees.remove(0);
                                }
                                break;

                            case "last":
                                for (int j = 0; j < Integer.parseInt(command.get(2)); j++) {
                                    coffees.remove(coffees.size() - 1);
                                }
                                break;
                        }
                    }
                    break;

                case "Prefer":
                    if (Integer.parseInt(command.get(1)) <= coffees.size() - 1
                    && Integer.parseInt(command.get(2)) <= coffees.size() - 1) {
                        String buffer = coffees.get(Integer.parseInt(command.get(1)));
                        coffees.set(Integer.parseInt(command.get(1)), coffees.get(Integer.parseInt(command.get(2))));
                        coffees.set(Integer.parseInt(command.get(2)), buffer);
                    }
                    break;

                case "Reverse":
                    Collections.reverse(coffees);
                    break;
            }
        }
        System.out.println("Coffees:");
        System.out.println(String.join(" ", coffees));
    }
}
