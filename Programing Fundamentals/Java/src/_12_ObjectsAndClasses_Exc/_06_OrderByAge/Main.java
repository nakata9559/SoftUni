package _12_ObjectsAndClasses_Exc._06_OrderByAge;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> personsDetails = new ArrayList<>();

        while (true) {
            String[] inputDetails = scanner.nextLine().split(" ");
            if (inputDetails[0].equals("End")) {
                break;
            }

            Person eachPersonsDetails = new Person();

            eachPersonsDetails.setName(inputDetails[0]);
            eachPersonsDetails.setID(Integer.parseInt(inputDetails[1]));
            eachPersonsDetails.setAge(Integer.parseInt(inputDetails[2]));

            personsDetails.add(eachPersonsDetails);
        }

        Collections.sort(personsDetails, Comparator.comparingInt(Person::getAge));

        for (Person eachPersonsDetails : personsDetails) {
            System.out.println(eachPersonsDetails.printDetails());
        }
    }
}
