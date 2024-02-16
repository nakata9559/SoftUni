package _12_ObjectsAndClasses_Exc._03_OpinionPoll;

public class Person {

    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDetails() {
        return String.format("%s - %d", this.name, this.age);
    }
}
