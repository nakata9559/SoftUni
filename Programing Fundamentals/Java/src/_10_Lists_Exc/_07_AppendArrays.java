package _10_Lists_Exc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _07_AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input =
                Arrays.stream(scanner.nextLine().split("\\|"))
                        .map(String::valueOf)
                        .collect(Collectors.toList());

        Collections.reverse(input);

        for (int i = 0; i < input.size(); i++) {
            List<String> eachArray =
                    Arrays.stream(input.get(i).split("\\s+"))
                            .map(String::valueOf)
                            .collect(Collectors.toList());

            if (eachArray.isEmpty() || eachArray.get(0).isEmpty() && eachArray.size() == 1) {
                continue;
            } else if (eachArray.get(0).equals("")) {
                eachArray.remove(0);
            }

            System.out.print(String.join(" ", eachArray.stream()
                    .map(String::valueOf)
                    .collect(Collectors.toList())));

            if (i < input.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
