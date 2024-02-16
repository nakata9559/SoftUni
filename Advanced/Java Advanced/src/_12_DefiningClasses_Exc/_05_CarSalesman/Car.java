package _12_DefiningClasses_Exc._05_CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Engine getEngine() {
        return engine;
    }

    public Car(){}


    public Car(String model, Engine engine) {
        this(model, engine, Integer.MIN_VALUE, "n/a");
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, Integer.MIN_VALUE, color);
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s:%n" +
                "%s%n" +
                "Weight: %s%n" +
                "Color: %s",
                this.model,
                this.engine,
                String.valueOf(this.weight).replaceAll(String.valueOf(Integer.MIN_VALUE), "n/a"),
                this.color);
    }
}
