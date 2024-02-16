package _12_DefiningClasses_Exc._04_RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire tires;

    public Car(String model, Engine engine, Cargo cargo, Tire tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public void printModel() {
        System.out.println(model);
    }

    public boolean checkPower() {
        return this.engine.checkPower();
    }

    public boolean checkType(String command) {
        return this.cargo.checkType(command);
    }

    public boolean checkPressure() {
        return this.tires.checkPressure();
    }
}
