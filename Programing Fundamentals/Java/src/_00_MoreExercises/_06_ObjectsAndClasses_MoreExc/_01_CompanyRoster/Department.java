package _00_MoreExercises._06_ObjectsAndClasses_MoreExc._01_CompanyRoster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Department {

    private String department;
    private List<Employee> employeesData = new ArrayList<>();

    public Department (String eachDepartment, String[] inputEmployeeData) {
        this.department = eachDepartment;

        Employee eachEmployeeData = new Employee(
                inputEmployeeData[0],
                Double.parseDouble(inputEmployeeData[1]),
                inputEmployeeData[2],
                inputEmployeeData[3]);

        if (inputEmployeeData.length == 6) {
            eachEmployeeData.setEmail(inputEmployeeData[4]);
            eachEmployeeData.setAge(Integer.parseInt(inputEmployeeData[5]));

        } else if (inputEmployeeData.length == 5
                && inputEmployeeData[4].contains("@")) {
            eachEmployeeData.setEmail(inputEmployeeData[4]);

        } else  if (inputEmployeeData.length == 5){
            eachEmployeeData.setAge(Integer.parseInt(inputEmployeeData[4]));
        }

        employeesData.add(eachEmployeeData);
    }

    public void setEmployeesData(String[] inputEmployeeData) {
        Employee eachEmployeeData = new Employee(
                inputEmployeeData[0],
                Double.parseDouble(inputEmployeeData[1]),
                inputEmployeeData[2],
                inputEmployeeData[3]);

        if (inputEmployeeData.length == 6) {
            eachEmployeeData.setEmail(inputEmployeeData[4]);
            eachEmployeeData.setAge(Integer.parseInt(inputEmployeeData[5]));

        } else if (inputEmployeeData.length == 5
                && inputEmployeeData[4].contains("@")) {
            eachEmployeeData.setEmail(inputEmployeeData[4]);

        } else if (inputEmployeeData.length == 5){
            eachEmployeeData.setAge(Integer.parseInt(inputEmployeeData[4]));
        }

        employeesData.add(eachEmployeeData);

        Collections.sort(employeesData, Comparator.comparingDouble(Employee::getSalary).reversed());

    }

    public double getAverageSalaryByDepartment(List<Employee> eachEmployeeByDepartment) {
        double eachDepartmentSalary = 0;

        for (Employee employee : eachEmployeeByDepartment) {
            eachDepartmentSalary += employee.getSalary();
        }

        return eachDepartmentSalary / eachEmployeeByDepartment.size();
    }


    public String getDepartment() {
        return department;
    }

    public List<Employee> getEmployeesData() {
        return employeesData;
    }
}
