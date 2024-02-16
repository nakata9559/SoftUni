package _11_ObjectsAndClasses_Lab._06_Students_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> studentDetails = new ArrayList<>();

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("end")) {
                break;
            }

            if (!isStudentExisting(studentDetails, input[0], input[1])) {
                Student student = new Student();

                student.setFirstName(input[0]);
                student.setLastName(input[1]);
                student.setAge(Integer.parseInt(input[2]));
                student.setHometown(input[3]);

                studentDetails.add(student);

            } else {
                Student student = getStudent(studentDetails, input[0], input[1]);

                student.setAge(Integer.parseInt(input[2]));
                student.setHometown(input[3]);
            }
        }

        String cityName = scanner.nextLine();

        for (Student student : studentDetails) {
            if (student.getHometown().equals(cityName)) {
                System.out.println(student.getDetails());
            }
        }
    }

    private static boolean isStudentExisting(List<Student> students, String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }

    private static Student getStudent(List<Student> students, String firstName, String lastName) {
        Student existingStudent = null;

        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                existingStudent = student;
            }

        }
        return existingStudent;
    }
}
