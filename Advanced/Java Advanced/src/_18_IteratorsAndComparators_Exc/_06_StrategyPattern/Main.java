package _18_IteratorsAndComparators_Exc._06_StrategyPattern;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfPeople = Integer.parseInt(scanner.nextLine());

        Set<Person> comparedByName = new TreeSet<>(new NameComparator());
        Set<Person> comparedByAge = new TreeSet<>(new AgeComparator());

        while (numOfPeople-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            comparedByName.add(person);
            comparedByAge.add(person);
        }

        comparedByName.forEach(System.out::println);
        comparedByAge.forEach(System.out::println);
    }
}
