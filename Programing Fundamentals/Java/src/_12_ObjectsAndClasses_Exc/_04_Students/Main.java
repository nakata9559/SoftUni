package _12_ObjectsAndClasses_Exc._04_Students;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> studentDetails = new ArrayList<>();

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfStudents; i++) {
            String[] inputDetails = scanner.nextLine().split(" ");

            Student eachStudentDetails = new Student(
                    inputDetails[0],
                    inputDetails[1],
                    Double.parseDouble(inputDetails[2]));

            studentDetails.add(eachStudentDetails);
        }

        Collections.sort(studentDetails, Comparator.comparingDouble(Student::getGrade).reversed());

        for (Student details : studentDetails) {
            System.out.println(details.getDetails());
        }
    }
}
