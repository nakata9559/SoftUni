package _12_DefiningClasses_Exc._04_RawData;

public class Cargo {
    private int weight;
    private String type;

    public Cargo(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    public boolean checkType(String command) {
        return this.type.equals(command);
    }
}
