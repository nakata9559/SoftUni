package _10_Lists_Exc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _08_AnonymousThreat {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> input =
                Arrays.stream(scanner.nextLine()
                        .split(" "))
                        .collect(Collectors.toList());

        List<String> command =
                Arrays.stream(scanner.nextLine()
                        .split(" "))
                        .collect(Collectors.toList());

        while (!command.get(0).equals("3:1")) {
            switch (command.get(0)) {
                case "merge":
                    if (Integer.parseInt(command.get(1)) < 0) {
                        command.set(1, "0");
                    }

                    if (Integer.parseInt(command.get(2)) > input.size() - 1) {
                        command.set(2, String.valueOf(input.size() - 1));
                    }

                    merge(input,
                            Integer.parseInt(command.get(1)),
                            Integer.parseInt(command.get(2)));

                    break;

                case "divide":
                    divide(input,
                            Integer.parseInt(command.get(1)),
                            Integer.parseInt(command.get(2)));
                    break;
            }

            command = Arrays.stream(scanner.nextLine()
                            .split(" "))
                            .collect(Collectors.toList());
        }

        System.out.println(String.join(" ", input.stream()
                .map(String::valueOf)
                .collect(Collectors.toList())));
    }

    public static void merge (List<String> input, int startIndex, int endIndex) {
        if (startIndex >= 0
                && startIndex <= input.size() - 1
                && endIndex >= 0
                && endIndex <= input.size() - 1) {

            for (int i = startIndex + 1; i <= endIndex; i++) {
                input.set(startIndex, input.get(startIndex) + input.get(i));
                input.remove(i);
                i--;
                endIndex--;
            }
        }
    }

    public static void divide (List<String> input, int index, int partitions) {
        if (index >= 0 && index <= input.size() - 1) {
            String textForDivide = input.get(index);
            input.remove(index);

            int countSymbolsPerPart = textForDivide.length() / partitions;

            int beginIndex = 0;
            for (int partition = 1; partition < partitions; partition++) {
                String textPerPart = textForDivide.substring(beginIndex, beginIndex + countSymbolsPerPart);
                input.add(index, textPerPart);
                index++;
                beginIndex += countSymbolsPerPart;
            }

            String textLastParts = textForDivide.substring(beginIndex, textForDivide.length());
            input.add(index, textLastParts);
        }
    }
}
