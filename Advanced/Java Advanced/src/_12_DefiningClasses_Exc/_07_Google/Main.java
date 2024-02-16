package _12_DefiningClasses_Exc._07_Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> peopleData = new HashMap<>();
        String[] tokens = scanner.nextLine().split("\\s+");

        while (!"End".equals(tokens[0])) {
            String personName = tokens[0];
            String object = tokens[1];
            Person currentPerson;

            if (peopleData.isEmpty()) {
                currentPerson = new Person();
                currentPerson.setName(personName);

            }else if (peopleData.containsKey(personName)) {
                currentPerson = peopleData.get(personName);

            } else {
                currentPerson = new Person();
                currentPerson.setName(personName);
            }

            switch (object) {
                case "company":
                    Company company = new Company(tokens[2], tokens[3], Double.parseDouble(tokens[4]));
                    currentPerson.setCompany(company);
                    break;

                case "pokemon":
                    Pokemon pokemon = new Pokemon(tokens[2], tokens[3]);
                    currentPerson.setPokemons(pokemon);
                    break;

                case "parents":
                    Parent parent = new Parent(tokens[2], tokens[3]);
                    currentPerson.setParents(parent);
                    break;

                case "children":
                    Child child = new Child(tokens[2], tokens[3]);
                    currentPerson.setChildren(child);
                    break;

                case "car":
                    Car car = new Car(tokens[2], Integer.parseInt(tokens[3]));
                    currentPerson.setCar(car);
                    break;
            }

            peopleData.put(personName, currentPerson);

            tokens = scanner.nextLine().split("\\s+");
        }
        System.out.println(peopleData.get(scanner.nextLine()));
    }
}
