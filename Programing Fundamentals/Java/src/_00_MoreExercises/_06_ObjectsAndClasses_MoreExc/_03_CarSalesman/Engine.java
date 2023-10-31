package _00_MoreExercises._06_ObjectsAndClasses_MoreExc._03_CarSalesman;

public class Engine {
    private String model;
    private String power;
    private String displacement = "n/a";
    private String efficiency = "n/a";

    public Engine(String model, String power) {
        this.model = model;
        this.power = power;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }


    @Override
    public String toString() {
        return String.format("    Power: %s%n" +
                "    Displacement: %s%n" +
                "    Efficiency: %s%n", power, displacement, efficiency);
    }
}
