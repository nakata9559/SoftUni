package _10_Polymorphism_Exc._02_VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double distanceTraveled;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
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

    protected double getTankCapacity() {
        return this.tankCapacity;
    }

    protected void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
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
        if (quantity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        if (quantity + this.getFuelQuantity() <= this.getTankCapacity()) {
            this.setFuelQuantity(this.getFuelQuantity() + quantity);
        } else {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",
                this.getClass().getSimpleName(),
                this.getFuelQuantity());
    }
}
