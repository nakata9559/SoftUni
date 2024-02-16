package _05_SetsAndMapsAdvanced_Lab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class _08_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfStudents = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentsData = new TreeMap<>();

        for (int i = 0; i < numOfStudents; i++) {
            String name = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());

            studentsData.putIfAbsent(name, grades);
        }

        studentsData.forEach((k, v) -> {
            double averageGrades = 0;
            for (int i = 0; i < v.size(); i++) {
                averageGrades += v.get(i);
            }
            averageGrades /= v.size();

            DecimalFormat format = new DecimalFormat("0.###############################");

            System.out.printf("%s is graduated with %s%n",
                    k,
                    format.format(averageGrades));
        });
    }
}
