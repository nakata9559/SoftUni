package _00_MoreExercises._06_ObjectsAndClasses_MoreExc._03_CarSalesman;

import java.util.List;

public class Car {

    private String model;
    private String engineModel;
    private List<Engine> engine;
    private String weight = "n/a";
    private String color = "n/a";

    public Car (String model,String engineModel, List<Engine> engine) {
        this.model = model;
        this.engineModel = engineModel;
        this.engine = engine;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        Engine engineOutput = new Engine("", "");

        for (Engine engine : engine) {
            if (engineModel.equals(engine.getModel())) {
                engineOutput = engine;
            }
        }
        return String.format("%s:%n" +
                "  %s:%n" +
                 engineOutput +
                "  Weight: %s%n" +
                "  Color: %s%n",
                model,
                engineModel,
                weight,
                color);
    }
}
