package _01_WorkingWithAbstraction_Lab._03_StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem()
    {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void inputStudentData(String name, int age, double grade)
    {
        if (!this.repo.containsKey(name))
        {
            Student student = new Student(name, age, grade);
            this.repo.put(name,student);
        }
    }

    public void showStudentData(String name)
    {
        if (this.repo.containsKey(name)) {
            Student student = this.repo.get(name);
            System.out.printf("%s is %d years old. ", student.getName(), student.getAge());
            double grade = student.getGrade();
            showReview(grade);
        }
    }

    private void showReview(double grade)
    {
        if (grade >= 5.00) {
            System.out.println("Excellent student.");
        }
        else if (grade >= 3.50)
        {
            System.out.println("Average student.");
        }
        else
        {
            System.out.println("Very nice person.");
        }
    }
}
