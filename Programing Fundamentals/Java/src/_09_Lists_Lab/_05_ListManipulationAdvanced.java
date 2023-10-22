package _09_Lists_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _05_ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers =
                Arrays.stream(
                        scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<String> command =
                Arrays.stream(scanner.nextLine().split(" "))
                        .collect(Collectors.toList());

        while (!command.get(0).equals("end")) {
            switch (command.get(0)) {
                case "Contains":
                    boolean contains = true;

                    for (int element:numbers) {

                        if (Integer.parseInt(command.get(1)) == element) {
                            System.out.println("Yes");
                            contains = true;
                            break;

                        } else {
                            contains = false;
                        }
                    }

                    if (!contains) {
                        System.out.println("No such number");
                    }
                    break;

                case "Print":
                    switch (command.get(1)){
                        case "even":
                            for (int element:numbers) {
                                if (element % 2 == 0) {
                                    System.out.print(element + " ");
                                }
                            }
                            System.out.println();
                            break;

                        case "odd":
                            for (int element:numbers) {
                                if (element % 2 != 0) {
                                    System.out.print(element + " ");
                                }
                            }
                            System.out.println();
                            break;
                    }
                    break;

                case "Get":
                    int sum = 0;

                    for (int element:numbers) {
                        sum += element;
                    }

                    System.out.println(sum);
                    break;

                case "Filter":
                    switch (command.get(1)) {
                        case "<":
                            for (int element : numbers) {
                                if (element < Integer.parseInt(command.get(2))) {
                                    System.out.print(element + " ");
                                }
                            }
                            System.out.println();
                            break;

                        case ">":
                            for (int element : numbers) {
                                if (element > Integer.parseInt(command.get(2))) {
                                    System.out.print(element + " ");
                                }
                            }
                            System.out.println();
                            break;

                        case ">=":
                            for (int element : numbers) {
                                if (element >= Integer.parseInt(command.get(2))) {
                                    System.out.print(element + " ");
                                }
                            }
                            System.out.println();
                            break;

                        case "<=":
                            for (int element : numbers) {
                                if (element <= Integer.parseInt(command.get(2))) {
                                    System.out.print(element + " ");
                                }
                            }
                            System.out.println();
                            break;
                    }
                    break;
            }

            command = Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .collect(Collectors.toList());
        }
    }
}
