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

        for (int i = 0; i < input.size(); i++) {
            input.set(i, input.get(i).replaceAll("\\s+", " "));

            List<String> eachElement =
                    Arrays.stream(input.get(i).split(" "))
                            .collect(Collectors.toList());

            for (int j = 0; j < eachElement.size(); j++) {
                if (eachElement.get(0).equals("")) {
                eachElement.remove(0);
                }

                if (eachElement.get(eachElement.size() - 1).equals("")) {
                    eachElement.remove(eachElement.size() - 1);
                }
            }
            input.set(i, String.join(" ", eachElement));
        }
        Collections.reverse(input);

        System.out.println(String.join(" ", input.stream()
                .map(String::valueOf)
                .collect(Collectors.toList())));
    }
}
