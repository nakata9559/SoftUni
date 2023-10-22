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
                    int startIndex = Integer.parseInt(command.get(1));
                    int endIndex = Integer.parseInt(command.get(2));
                    int itemsRemoved = 0;

                    for (int i = startIndex + 1; i <= endIndex - itemsRemoved; i++) {
                        input.set(startIndex, input.get(startIndex) + input.get(i));
                        input.remove(i);
                        itemsRemoved++;
                        i--;
                    }
                    break;

                case "divide":

                    break;
            }

            command = Arrays.stream(scanner.nextLine()
                            .split(" "))
                            .collect(Collectors.toList());
        }
    }
}
