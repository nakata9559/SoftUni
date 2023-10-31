package _00_MoreExercises._06_ObjectsAndClasses_MoreExc._01_CompanyRoster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Department> dataByDepartment = new ArrayList<>();

        int numOfEmployees = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfEmployees; i++) {
            List <Department> checkDepartment = new ArrayList<>(dataByDepartment);

            String[] inputEmployeeData = scanner.nextLine().split(" ");

            Department eachDepartment = new Department(inputEmployeeData[3], inputEmployeeData);


            if (!dataByDepartment.isEmpty()) {
                boolean exists = false;

                for (Department department : checkDepartment) {
                    if (department.getDepartment().contains(inputEmployeeData[3])) {
                        exists = true;
                        department.setEmployeesData(inputEmployeeData);
                        break;
                    }
                }
                if (!exists) {
                    dataByDepartment.add(eachDepartment);
                }

            } else {
                dataByDepartment.add(eachDepartment);
            }
        }

        Department maxAverageSalaryDepartment = dataByDepartment.get(0);
        double maxAverageSalary = Double.MIN_VALUE;

        for (Department department : dataByDepartment) {
            if (department.getAverageSalaryByDepartment(department.getEmployeesData()) > maxAverageSalary) {
                maxAverageSalaryDepartment = department;
                maxAverageSalary = department.getAverageSalaryByDepartment(department.getEmployeesData());
            }
        }

        System.out.printf("Highest Average Salary: %s%n", maxAverageSalaryDepartment.getDepartment());

        for (Department department : dataByDepartment) {
            if (department.equals(maxAverageSalaryDepartment)) {
                for (Employee employee : department.getEmployeesData()) {
                    System.out.println(employee.printHighestSalaryDepartmentEmployee());
                }
            }
        }
    }
}