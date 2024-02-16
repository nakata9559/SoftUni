package _12_DefiningClasses_Exc._01_OpinionPoll;

public class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printDetails() {
        System.out.println(this.name + " - " + this.age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
