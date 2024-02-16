package _01_FirstStepsInCoding_Lab;

import java.util.Scanner;

public class _06_ConcatenateData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String FirstName = scanner.nextLine();
        String LastName = scanner.nextLine();
        int Age = Integer.parseInt(scanner.nextLine());
        String Town = scanner.nextLine();
        System.out.printf("You are %s %s, a %d-years old person from %s.", FirstName, LastName, Age, Town);
    }
}
