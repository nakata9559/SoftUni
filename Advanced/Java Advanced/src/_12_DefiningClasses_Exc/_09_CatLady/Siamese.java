package _12_DefiningClasses_Exc._09_CatLady;

public class Siamese extends Cat {
    private double earsSize;

    public Siamese(String name, double earsSize) {
        super(name);
        this.earsSize = earsSize;
    }

    public String toString() {
        return String.format("Siamese %s %.2f", super.getName(), this.earsSize);
    }
}
