package _14_PreExam;

import java.util.Scanner;

public class _04_Exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfStudents = Integer.parseInt(scanner.nextLine());

        int topStudents = 0;
        int studentsGrades4To5 = 0;
        int studentsGrades3To4 = 0;
        int studentsFailed = 0;
        double totalGrades = 0;

        for (int i = 0; i < numOfStudents; i++) {

            double gradePerStudent = Double.parseDouble(scanner.nextLine());
            totalGrades += gradePerStudent;

            if (gradePerStudent < 3) {
                studentsFailed++;

            } else if (gradePerStudent < 4) {
                studentsGrades3To4++;

            } else if (gradePerStudent < 5) {
                studentsGrades4To5++;

            } else {
                topStudents++;
            }

        }
        double topStudentsPercentage = 100.0 * topStudents / numOfStudents;
        double studentsGrades4To5Percentage = 100.0 * studentsGrades4To5 / numOfStudents;
        double studentsGrades3To4Percentage = 100.0 * studentsGrades3To4 / numOfStudents;
        double studentsFailedPercentage = 100.0 * studentsFailed / numOfStudents;
        double totalAverageGrades = totalGrades / numOfStudents;

        System.out.printf("Top students: %.2f%%%n", topStudentsPercentage);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", studentsGrades4To5Percentage);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", studentsGrades3To4Percentage);
        System.out.printf("Fail: %.2f%%%n", studentsFailedPercentage);
        System.out.printf("Average: %.2f%n", totalAverageGrades);


    }
}
