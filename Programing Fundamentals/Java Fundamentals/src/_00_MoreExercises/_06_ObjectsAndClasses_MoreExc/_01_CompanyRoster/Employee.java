package _00_MoreExercises._06_ObjectsAndClasses_MoreExc._01_CompanyRoster;

public class Employee {

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email = "n/a";
    private int age = -1;

    public Employee(String name,
                    double salary,
                    String position,
                    String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String printHighestSalaryDepartmentEmployee() {
        return String.format("%s %.2f %s %d",
                this.name,
                this.salary,
                this.email,
                this.age);
    }
}
