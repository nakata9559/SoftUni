package _00_MoreExercises._05_Lists_MoreExc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _05_DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double savings = Double.parseDouble(scanner.nextLine());

        List<Integer> initialDrumSet =
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer> drumSet = new ArrayList<>(initialDrumSet);

        String command = scanner.nextLine();

        while (!command.equals("Hit it again, Gabsy!")) {

            for (int i = 0; i < drumSet.size(); i++) {
                drumSet.set(i, drumSet.get(i) - Integer.parseInt(command));

                if (drumSet.get(i) <= 0
                && savings - initialDrumSet.get(i) * 3 >= 0) {
                        drumSet.set(i, initialDrumSet.get(i));
                        savings -= initialDrumSet.get(i) * 3;
                }
            }

            command = scanner.nextLine();
        }

        for (int i = 0; i < drumSet.size(); i++) {
            if (drumSet.get(i) <= 0) {
                drumSet.remove(i);
                i--;
            }
        }

        System.out.println(String.join(" ", drumSet.stream()
                .map(String::valueOf)
                .collect(Collectors.toList())));

        System.out.printf("Gabsy has %.2flv.%n", savings);
    }
}
