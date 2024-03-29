package _03_Encapsulation_Lab._01_SortByNameAndAge;

public class Person {
    private final String TO_STRING_TEMPLATE = "%s %s is %d years old.";
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_TEMPLATE,
                this.getFirstName(),
                this.getLastName(),
                this.getAge());
    }
}
