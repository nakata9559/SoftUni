package _18_IteratorsAndComparators_Exc._05_ComparingObjects;

public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private String town;
    private int[] output = new int[3];

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person person) {
        this.output[2]++;
        if (person.getName().compareTo(this.name) == 0
        && person.getAge() == this.age
        && person.getTown().compareTo(this.town) == 0) {
            this.output[0]++;
        } else {
            this.output[1]++;
        }
        return 0;
    }

    public int[] getOutput() {
        return output;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }
}
