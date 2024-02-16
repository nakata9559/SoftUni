package _00_MoreExercises._05_Lists_MoreExc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> code =
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<String> inputMessage =
                Arrays.stream(scanner.nextLine().split(""))
                        .collect(Collectors.toList());

        for (int i = 0; i < code.size(); i++) {
            int sumIndex = 0;
            for (int j = 0; j < code.get(i).toString().length(); j++) {
                sumIndex += Integer.parseInt(String.valueOf(code.get(i).toString().charAt(j)));
                if (sumIndex >= inputMessage.size()) {
                    sumIndex = sumIndex - inputMessage.size();
                }
            }
            System.out.printf("%s", inputMessage.get(sumIndex));
            inputMessage.remove(sumIndex);
        }
        System.out.println();
    }
}
