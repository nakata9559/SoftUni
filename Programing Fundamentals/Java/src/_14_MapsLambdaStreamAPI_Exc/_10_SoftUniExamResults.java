package _14_MapsLambdaStreamAPI_Exc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _10_SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> participants = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> points = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> submissions = new LinkedHashMap<>();

        while(true){
            String[] input = scanner.nextLine().split("-");

            if (input[0].equals("exam finished")){
                break;
            }

            String student = input[0];

            if (participants.containsKey(student) && input[1].equals("banned")) {
                participants.remove(student);
                points.remove(student);
                continue;
            }

            String language = input[1];
            int pointsPerStudent = Integer.parseInt(input[2]);

            participants.put(student, language);

            if (!points.containsKey(student)) {
                points.put(student, pointsPerStudent);
            } else {
                for (Map.Entry<String, Integer> entry : points.entrySet()) {
                    if (entry.getKey().equals(student) && entry.getValue() < pointsPerStudent) {
                        points.put(student, pointsPerStudent);
                    }
                }
            }

            if (!submissions.containsKey(language)) {
                submissions.put(language, 1);
            } else {
                submissions.put(language, submissions.get(language) + 1);
            }
        }

        System.out.println("Results:");
        points.forEach((key, value) -> System.out.printf("%s | %d%n", key, value));
        System.out.println("Submissions:");
        submissions.forEach((key, value) -> System.out.printf("%s - %d%n", key, value));
    }
}
