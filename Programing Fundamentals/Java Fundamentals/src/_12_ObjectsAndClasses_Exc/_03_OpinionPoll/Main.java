package _12_ObjectsAndClasses_Exc._03_OpinionPoll;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int linesOfInformation = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < linesOfInformation; i++) {
            String[] input = scanner.nextLine().split(" ");

            Person eachPersonSDetails = new Person();

            eachPersonSDetails.setName(input[0]);
            eachPersonSDetails.setAge(Integer.parseInt(input[1]));

            if (eachPersonSDetails.getAge() > 30) {
                System.out.println(eachPersonSDetails.getDetails());
            }
        }
    }
}
