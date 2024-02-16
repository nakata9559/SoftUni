package _12_DefiningClasses_Exc._09_CatLady;

public class StreetExtraordinaire extends Cat {
    private double decibels;

    public StreetExtraordinaire(String name, double decibels) {
        super(name);
        this.decibels = decibels;
    }

    public String toString() {
        return String.format("StreetExtraordinaire %s %.2f", super.getName(), this.decibels);
    }
}
