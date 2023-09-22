package _10_WhileLoop_Exc;

import java.util.Scanner;

public class _02_ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int unwantedBadGrades = Integer.parseInt(scanner.nextLine());
        String exerciseName = scanner.nextLine();

        int totalGrades = 0;
        int totalProblems = 0;
        int badGradeCount = 0;
        String lastProblem = "";

        while (!exerciseName.equals("Enough") && unwantedBadGrades != badGradeCount) {

            int grade = Integer.parseInt(scanner.nextLine());
            totalGrades += grade;
            totalProblems++;
            lastProblem = exerciseName;

            if (grade <= 4) {
                badGradeCount++;
            }

            if (badGradeCount == unwantedBadGrades){
                System.out.printf("You need a break, %d poor grades.", badGradeCount);
                break;
            }

            exerciseName = scanner.nextLine();

        }

        System.out.printf("Average score: %.2f%n", 1.0 * totalGrades / totalProblems);
        System.out.printf("Number of problems: %d%n", totalProblems);
        System.out.printf("Last problem: %s", lastProblem);
    }
}
