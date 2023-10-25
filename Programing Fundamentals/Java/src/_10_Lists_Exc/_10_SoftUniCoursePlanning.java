package _10_Lists_Exc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _10_SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> courses =
                Arrays.stream(scanner.nextLine().split(", "))
                        .collect(Collectors.toList());

        List<String> command =
                Arrays.stream(scanner.nextLine().split(":"))
                        .collect(Collectors.toList());

        while (!command.contains("course start")) {
            switch (command.get(0)) {
                case "Add":
                    if (!courses.contains(command.get(1))) {
                        courses.add(command.get(1));
                    }
                    break;

                case "Insert":
                    if (!courses.contains(command.get(1))) {
                        courses.add(Integer.parseInt(command.get(2)), command.get(1));
                    }
                    break;

                case "Remove":
                    courses.remove(command.get(1));
                    break;

                case "Swap":
                    if (courses.contains(command.get(1)) && courses.contains(command.get(2))) {
                        int firstIndex = courses.indexOf(command.get(1));
                        int secondIndex = courses.indexOf(command.get(2));
                        String buffer = courses.get(firstIndex);

                        courses.set(firstIndex, courses.get(secondIndex));
                        courses.set(secondIndex, buffer);

                        if (courses.contains(command.get(1) + "-Exercise")
                        && courses.contains(command.get(2) + "-Exercise")) {
                            int firstExcIndex = courses.indexOf(command.get(1) + "-Exercise");
                            int secondExcIndex = courses.indexOf(command.get(2) + "-Exercise");
                            String bufferExc = courses.get(firstExcIndex);

                            courses.set(firstExcIndex, courses.get(secondExcIndex));
                            courses.set(secondExcIndex, bufferExc);

                        } else if (courses.contains(command.get(1) + "-Exercise")) {
                            int excIndex = courses.indexOf(command.get(1) + "-Exercise");
                            courses.add(secondIndex + 1, courses.get(excIndex));
                            courses.remove(excIndex);

                        } else if (courses.contains(command.get(2) + "-Exercise")) {
                            int excIndex = courses.indexOf(command.get(2) + "-Exercise");
                            courses.add(firstIndex + 1, courses.get(excIndex));
                            courses.remove(excIndex + 1);
                        }
                    }
                    break;

                case "Exercise":
                    int lessonIndex = courses.indexOf(command.get(1));

                    if (courses.contains(command.get(1))
                    && !courses.contains(command.get(1) + "-Exercise")) {
                        courses.add(lessonIndex + 1, command.get(1) + "-Exercise");

                    } else if (!courses.contains(command.get(1))) {
                        courses.add(command.get(1));
                        courses.add(command.get(1) + "-Exercise");
                    }
                    break;
            }
            command = Arrays.stream(scanner.nextLine().split(":"))
                    .collect(Collectors.toList());
        }

        for (int i = 0; i < courses.size(); i++) {
            System.out.println(i + 1 + "." + courses.get(i));
        }
    }
}
