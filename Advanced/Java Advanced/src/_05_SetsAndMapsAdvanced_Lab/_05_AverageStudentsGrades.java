package _05_SetsAndMapsAdvanced_Lab;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class _05_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfStudents = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentGrades = new TreeMap<>();

        for (int i = 0; i < numOfStudents; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            studentGrades.putIfAbsent(name, new ArrayList<>());
            studentGrades.get(name).add(grade);
        }

        studentGrades.forEach((k, v) -> {
            double averageGrades = 0;

            for (double num : v) {
                averageGrades += num;
            }
            averageGrades /= v.size();

            String allGrades = v.stream()
                    .map(num -> String.format("%.2f", num))
                    .collect(Collectors.joining(" "));

            System.out.printf("%s -> %s (avg: %.2f)%n",
                    k,
                    allGrades,
                    averageGrades);
        });
    }
}
