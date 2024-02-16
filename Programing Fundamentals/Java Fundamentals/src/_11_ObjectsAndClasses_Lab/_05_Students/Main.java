package _11_ObjectsAndClasses_Lab._05_Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> studentDetails = new ArrayList<>();

        while (true) {
            String[] eachStudentDetails = scanner.nextLine().split(" ");
            if (eachStudentDetails[0].equals("end")) {
                break;
            }

            Student eachStudent = new Student();

            eachStudent.setFirstName(eachStudentDetails[0]);
            eachStudent.setLastName(eachStudentDetails[1]);
            eachStudent.setAge(Integer.parseInt(eachStudentDetails[2]));
            eachStudent.setHometown(eachStudentDetails[3]);

            studentDetails.add(eachStudent);
        }

        String cityName = scanner.nextLine();

        for (Student student : studentDetails) {
            if (student.getHometown().equals(cityName)) {
                System.out.println(student.getDetails());
            }
        }
    }
}
