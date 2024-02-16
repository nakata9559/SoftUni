package _12_ObjectsAndClasses_Exc._05_VehicleCatalogue;

public class Catalog {

    private String typeOfVehicle;
    private String model;
    private String color;
    private int horsepower;


    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(String typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public String getModelDetails() {
        return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d",
                this.typeOfVehicle.substring(0, 1).toUpperCase() + this.typeOfVehicle.substring(1),
                this.model,
                this.color,
                this.horsepower);
    }


}
