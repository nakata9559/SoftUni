package _12_DefiningClasses_Exc._07_Google;

public class Child {
    private String name;
    private String birthDate;

    public Child(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }


    @Override
    public String toString() {
        return String.format("%n%s %s",
                this.name,
                this.birthDate);
    }
}
