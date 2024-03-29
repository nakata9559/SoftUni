package _10_Polymorphism_Exc._02_VehiclesExtension;

public class Truck extends Vehicle{

    protected Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + 1.6);
    }

    @Override
    protected void refuel(double quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        if (quantity + this.getFuelQuantity() * 0.95 <= this.getTankCapacity()) {
            this.setFuelQuantity(this.getFuelQuantity() + quantity * 0.95);
        } else {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
    }
}
