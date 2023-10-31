package _00_MoreExercises._06_ObjectsAndClasses_MoreExc._02_RawData;

public class Cargo {

    private int cargoWeight;
    private String cargoType;

    public Cargo(int cargoWeight, String cargoType) {
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }

    public String getCargoType() {
        return cargoType;
    }
}
