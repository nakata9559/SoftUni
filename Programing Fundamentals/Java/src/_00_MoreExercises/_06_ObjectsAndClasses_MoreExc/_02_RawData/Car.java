package _00_MoreExercises._06_ObjectsAndClasses_MoreExc._02_RawData;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private String model;
    private String cargoType;
    private double minTirePressure;
    private int enginePower;
    private List<Engine> engineData = new ArrayList<>();
    private List<Cargo> cargoData = new ArrayList<>();
    private List<Tires> tiresData = new ArrayList<>();

    public Car(String model,
               String[] engineData,
               String[] cargoData,
               String[] tiresData) {
        this.model = model;
        Engine eachEngineData = new Engine(Integer.parseInt(engineData[0]),
                Integer.parseInt(engineData[1]));
        Cargo eachCargoData = new Cargo(Integer.parseInt(cargoData[0]), cargoData[1]);
        Tires eachTiresData = new Tires(Double.parseDouble(tiresData[0]), Integer.parseInt(tiresData[1]),
                Double.parseDouble(tiresData[2]), Integer.parseInt(tiresData[3]),
                Double.parseDouble(tiresData[4]), Integer.parseInt(tiresData[5]),
                Double.parseDouble(tiresData[6]), Integer.parseInt(tiresData[7]));

        this.engineData.add(eachEngineData);
        this.cargoData.add(eachCargoData);
        this.tiresData.add(eachTiresData);

        this.cargoType = eachCargoData.getCargoType();
        this.minTirePressure = eachTiresData.getMinPressure();
        this.enginePower = eachEngineData.getEnginePower();
    }

    public String getModel() {
        return model;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public double getMinTirePressure() {
        return minTirePressure;
    }
}
