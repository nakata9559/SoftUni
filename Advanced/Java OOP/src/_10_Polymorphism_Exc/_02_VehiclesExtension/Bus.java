package _10_Polymorphism_Exc._02_VehiclesExtension;

import java.text.DecimalFormat;

public class Bus extends Vehicle{

    protected Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + 1.4);
    }

    protected void driveEmpty(double distance) {
        if (distance * (super.getFuelConsumption() - 1.4) <= super.getFuelQuantity()) {
            super.setFuelQuantity(super.getFuelQuantity() - distance * (super.getFuelConsumption() - 1.4));
            super.setDistanceTraveled(super.getDistanceTraveled() + distance);
            DecimalFormat df = new DecimalFormat("#.##");
            throw new IllegalArgumentException(super.getClass().getSimpleName() + " travelled " + df.format(distance) + " km");
        } else {
            throw new IllegalArgumentException(this.getClass().getSimpleName() + " needs refueling");
        }
    }
}
