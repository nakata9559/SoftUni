package _10_Polymorphism_Exc._01_Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double distanceTraveled;

    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.distanceTraveled = 0.0;
    }

    protected double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected double getFuelConsumption() {
        return this.fuelConsumption;
    }

    protected double getDistanceTraveled() {
        return this.distanceTraveled;
    }

    protected void setDistanceTraveled(double distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    protected void drive(double distance) {
        if (distance * this.getFuelConsumption() <= this.getFuelQuantity()) {
            this.setFuelQuantity(this.getFuelQuantity() - distance * this.getFuelConsumption());
            this.setDistanceTraveled(this.getDistanceTraveled() + distance);
            DecimalFormat df = new DecimalFormat("#.##");
            throw new IllegalArgumentException(this.getClass().getSimpleName() + " travelled " + df.format(distance) + " km");
        } else {
            throw new IllegalArgumentException(this.getClass().getSimpleName() + " needs refueling");
        }
    }

    protected void refuel(double quantity) {
        this.setFuelQuantity(this.getFuelQuantity() + quantity);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",
                this.getClass().getSimpleName(),
                this.getFuelQuantity());
    }
}
