package _12_DefiningClasses_Exc._05_CarSalesman;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(){}

    public Engine(String model, int power) {
        this(model, power, Integer.MIN_VALUE, "n/a");
    }

    public Engine(String model, int power, int displacement) {
        this(model, power, displacement, "n/a");
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power, Integer.MIN_VALUE, efficiency);
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return String.format("%s:%n" +
                        "Power: %d%n" +
                        "Displacement: %s%n" +
                        "Efficiency: %s",
                this.model,
                this.power,
                String.valueOf(this.displacement).replaceAll(String.valueOf(Integer.MIN_VALUE), "n/a"),
                this.efficiency);
    }
}
