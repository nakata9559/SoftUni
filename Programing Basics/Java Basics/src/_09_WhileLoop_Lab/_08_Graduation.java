package _09_WhileLoop_Lab;

import java.util.Scanner;

public class _08_Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* ---FOR LOOP---
        String name = scanner.nextLine();

        double totalGrades = 0;
        int badGradeTimes = 0;

        for (int i = 1; i <= 12; i++) {

            if (badGradeTimes == 2) {
                System.out.printf("%s has been excluded at %d grade", name, i - 2);
                return;
            }

            double grades = Double.parseDouble(scanner.nextLine());
            totalGrades += grades;

            if (grades < 4) {
                badGradeTimes++;
            }
        }
        double averageGrades = totalGrades / 12;
        System.out.printf("%s graduated. Average grade: %.2f", name, averageGrades);
        */

        String name = scanner.nextLine();

        int badGradeTimes = 0;
        double totalGrades = 0;

        int grade = 1;

        while (grade <= 12) {
            if (badGradeTimes == 2) {
                System.out.printf("%s has been excluded at %d grade", name, grade - 2);
                break;
            }

            double grades = Double.parseDouble(scanner.nextLine());
            totalGrades += grades;

            if (grades < 4) {
                badGradeTimes++;
            }

            if (grade == 12) {
                System.out.printf("%s graduated. Average grade: %.2f", name, totalGrades / 12);
                break;
            }

            grade++;
        }
    }
}
