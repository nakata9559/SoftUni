package _18_IteratorsAndComparators_Exc._05_ComparingObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> peopleData = new ArrayList<>();

        String[] tokens = scanner.nextLine().split("\\s+");

        while (!"END".equals(tokens[0])) {
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];

            peopleData.add(new Person(name, age, town));

            tokens = scanner.nextLine().split("\\s+");
        }

        Person personToCompare = peopleData.get(Integer.parseInt(scanner.nextLine()) - 1);

        peopleData.forEach(personToCompare::compareTo);

        if (personToCompare.getOutput()[0] == 1
                && personToCompare.getOutput()[1] == 1
                || personToCompare.getOutput()[1] == 0) {
            System.out.println("No matches");
        } else {
            System.out.println(String
                    .join(" ", Arrays.stream(personToCompare.getOutput())
                            .mapToObj(String::valueOf)
                            .toArray(String[]::new)));
        }
    }
}
