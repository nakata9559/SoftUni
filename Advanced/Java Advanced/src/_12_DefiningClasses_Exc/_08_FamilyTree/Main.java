package _12_DefiningClasses_Exc._08_FamilyTree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String personId = scanner.nextLine();
        ;

        List<Person> people = new ArrayList<>();
        Map<String, List<String>> parentChildren = new LinkedHashMap<>();

        String line = scanner.nextLine();

        while(!"End".equals(line)) {
            if (line.contains(" - ")) {
                String[] tokens = line.split(" - ");
                String parentId = tokens[0];
                String childId = tokens[1];
                parentChildren.putIfAbsent(parentId, new ArrayList<>());
                parentChildren.get(parentId).add(childId);
            } else {
                String[] tokens = line.split("\\s+");
                String name = tokens[0] + " " + tokens[1];
                String birthDate = tokens[2];
                people.add(new Person(name, birthDate));
            }
            line = scanner.nextLine();
        }


        parentChildren.forEach((parentId, children) -> {
            Person parent = findPerson(people, parentId);

            children.stream()
                    .map(childId -> findPerson(people, childId))
                    .forEach(parent::addChild);
        });

        Person forPerson = findPerson(people, personId);

        System.out.println(getFamilyTreeFor(forPerson));
    }

    private static Person findPerson(List<Person> people, String personId) {
        return people.stream()
                .filter(person -> person.getBirthDate().equals(personId) || person.getName().equals(personId))
                .findFirst()
                .orElseThrow();
    }

    public static String getFamilyTreeFor(Person person) {
        return new StringBuilder()
                .append(person.toString()).append(System.lineSeparator())
                .append("Parents:").append(System.lineSeparator())
                .append(person.getParents().stream().map(Person::toString)
                        .collect(Collectors.joining(System.lineSeparator())))
                .append(person.getParents().isEmpty() ? "" : System.lineSeparator())
                .append("Children:").append(System.lineSeparator())
                .append(person.getChildren().stream().map(Person::toString)
                        .collect(Collectors.joining(System.lineSeparator())))
                .toString();
    }

    private static final class Person {
        private final String name;
        private final String birthDate;
        private final List<Person> parents = new ArrayList<>();
        private final List<Person> children = new ArrayList<>();

        public Person(String name, String birthDate) {
            this.name = name;
            this.birthDate = birthDate;
        }

        @Override
        public String toString() {
            return name + " " + birthDate;
        }

        public String getName() {
            return name;
        }

        public void addChild(Person child) {
            children.add(child);
            child.parents.add(this);
        }

        public String getBirthDate() {
            return birthDate;
        }

        public List<Person> getParents() {
            return Collections.unmodifiableList(parents);
        }

        public List<Person> getChildren() {
            return Collections.unmodifiableList(children);
        }
    }
}