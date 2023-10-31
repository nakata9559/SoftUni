package _12_ObjectsAndClasses_Exc._06_OrderByAge;

public class Person {

    private String name;
    private int ID;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String printDetails() {
        return String.format("%s with ID: %d is %d years old.",
                this.name,
                this.ID,
                this.age);
    }
}
