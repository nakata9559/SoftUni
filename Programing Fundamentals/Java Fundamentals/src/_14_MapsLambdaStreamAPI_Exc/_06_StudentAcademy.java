package _14_MapsLambdaStreamAPI_Exc;

import java.util.*;

public class _06_StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, List<Double>> studentData = new LinkedHashMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String name = scanner.nextLine();
            Double grade = Double.parseDouble(scanner.nextLine());

            if (!studentData.containsKey(name)) {
                studentData.put(name, new ArrayList<>());
                studentData.get(name).add(grade);
            } else {
                studentData.get(name).add(grade);
            }

        }

        for (Map.Entry<String, List<Double>> entry : studentData.entrySet()) {

            double sumGrade = 0;

            for (int i = 0; i < entry.getValue().size(); i++) {
                sumGrade += entry.getValue().get(i);
            }

            double averageGrade = sumGrade / entry.getValue().size();

            if (averageGrade >= 4.5) {
                System.out.printf("%s -> %.2f%n", entry.getKey(), averageGrade);
            }

        }
    }
}
