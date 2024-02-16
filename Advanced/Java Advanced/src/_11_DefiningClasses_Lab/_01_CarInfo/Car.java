package _11_DefiningClasses_Lab._01_CarInfo;

public class Car {

    private String brand;
    private String model;
    private int horsepower;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(String horsepower) {
        this.horsepower = Integer.parseInt(horsepower);
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.",
                this.getBrand(),
                this.getModel(),
                this.getHorsepower());
    }
}
