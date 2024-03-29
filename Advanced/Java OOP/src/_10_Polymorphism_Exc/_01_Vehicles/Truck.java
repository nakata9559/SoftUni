package _10_Polymorphism_Exc._01_Vehicles;

public class Truck extends Vehicle {

    protected Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + 1.6);
    }

    @Override
    protected void refuel(double quantity) {
        super.setFuelQuantity(super.getFuelQuantity() + quantity * 0.95);
    }
}
