package _00_MoreExercises._04_ForLoop_MoreExc;

import java.util.Scanner;

public class _04_Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentsTotal = Integer.parseInt(scanner.nextLine());

        int resultsFailed = 0;
        int results3To4 = 0;
        int results4To5 = 0;
        int results5Plus = 0;
        double gradesTotal = 0;

        for (int i = 0; i < studentsTotal; i++) {

            double grades = Double.parseDouble(scanner.nextLine());
            gradesTotal += grades;

            if (grades < 3) {
                resultsFailed++;
            } else if (grades < 4) {
                results3To4++;
            } else if (grades < 5) {
                results4To5++;
            } else {
                results5Plus++;
            }
        }

        double percentageFailed = 100.0 * resultsFailed / studentsTotal;
        double percentage3To4 = 100.0 * results3To4 / studentsTotal;
        double percentage4To5 = 100.0 * results4To5 / studentsTotal;
        double percentage5Plus = 100.0 * results5Plus / studentsTotal;
        double averageGrades = gradesTotal / studentsTotal;

        System.out.printf("Top students: %.2f%%%n", percentage5Plus);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", percentage4To5);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n",percentage3To4);
        System.out.printf("Fail: %.2f%%%n", percentageFailed);
        System.out.printf("Average: %.2f", averageGrades);
    }
}
