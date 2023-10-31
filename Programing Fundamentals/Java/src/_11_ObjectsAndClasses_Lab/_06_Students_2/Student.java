package _11_ObjectsAndClasses_Lab._06_Students_2;

public class Student {
    private String FirstName;
    private String LastName;
    private int Age;
    private String Hometown;


    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getHometown() {
        return Hometown;
    }

    public void setHometown(String hometown) {
        Hometown = hometown;
    }

    public String getDetails() {
        return String.format("%s %s is %d years old",
                this.FirstName,
                this.LastName,
                this.Age);
    }
}
