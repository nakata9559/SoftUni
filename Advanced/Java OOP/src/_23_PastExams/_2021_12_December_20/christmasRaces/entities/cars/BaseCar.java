package _23_PastExams._2021_12_December_20.christmasRaces.entities.cars;

import static _23_PastExams._2021_12_December_20.christmasRaces.common.ExceptionMessages.INVALID_MODEL;

public abstract class BaseCar implements Car{
    private String model;
    private int horsePower;
    private double cubicCentimeters;

    public BaseCar(String model, int horsePower, double cubicCentimeters) {
        this.setModel(model);
        this.setHorsePower(horsePower);
        this.cubicCentimeters = cubicCentimeters;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return this.cubicCentimeters / this.horsePower * laps;
    }

    protected void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    private void setModel(String model) {
        if (null == model || model.trim().isEmpty() || model.length() < 4) {
            throw new IllegalArgumentException(String.format(INVALID_MODEL, model, 4));
        }

        this.model = model;
    }
}
