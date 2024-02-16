package _11_DefiningClasses_Lab._02_Constructors;

public class Car {
    private String brand;
    private String model;
    private int horsepower;

    public Car() {

    }

    public Car(String brand) {
        this(brand, "unknown", "-1");
    }

    public Car(String brand, String model, String horsepower) {
        this.brand = brand;
        this.model = model;
        this.horsepower = Integer.parseInt(horsepower);
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.",
                this.brand,
                this.model,
                this.horsepower);
    }
}