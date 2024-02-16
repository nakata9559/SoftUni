package _01_FirstStepsInCoding_Lab;

import java.util.Scanner;

public class _07_ProjectsCreation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Name = scanner.nextLine();
        int Projects = Integer.parseInt(scanner.nextLine());
        int RequiredHours = Projects * 3;
        System.out.printf("The architect %s will need %d hours to complete %d project/s.", Name, RequiredHours, Projects);
    }
}
