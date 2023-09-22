package _10_WhileLoop_Exc;

import java.util.Scanner;

public class _04_Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int goal = 10000;
        String eachStep = scanner.nextLine();
        int sumSteps = 0;

        if (eachStep.equals("Going home")) {
            sumSteps = Integer.parseInt(scanner.nextLine());
        } else {
            sumSteps = Integer.parseInt(eachStep);
        }

        while (sumSteps < goal && !eachStep.equals("Going home")) {

            eachStep = scanner.nextLine();

            if (eachStep.equals("Going home")) {
                sumSteps += Integer.parseInt(scanner.nextLine());
                break;
            }

            sumSteps += Integer.parseInt(eachStep);

        }

        if (sumSteps >= goal) {
            System.out.printf("Goal reached! Good job!%n%d steps over the goal!", sumSteps - goal);
        } else {
            System.out.printf("%d more steps to reach goal.", goal - sumSteps);
        }
    }
}
