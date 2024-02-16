package _12_DefiningClasses_Exc._03_SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPerKilometer;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostPerKilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKilometer = fuelCostPerKilometer;
        this.distanceTraveled = 0;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public String getModel() {
        return model;
    }

    public void printCarDetails() {
        System.out.printf("%s %.2f %d%n",
                this.model,
                this.fuelAmount,
                this.distanceTraveled);
    }

    public double getFuelCostPerKilometer() {
        return fuelCostPerKilometer;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }
}
