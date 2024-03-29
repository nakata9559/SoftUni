package _01_WorkingWithAbstraction_Lab._03_StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        while (true)
        {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("Exit")){
                break;
            }
            String command = input[0];
            String name = input[1];

            if ("Create".equals(command))
            {
                int age = Integer.parseInt(input[2]);
                double grade = Double.parseDouble(input[3]);
                studentSystem.inputStudentData(name, age, grade);
            }
            else if ("Show".equals(command))
            {
                studentSystem.showStudentData(name);
            }
        }
    }
}
