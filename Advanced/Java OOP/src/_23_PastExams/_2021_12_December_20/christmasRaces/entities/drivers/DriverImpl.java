package _23_PastExams._2021_12_December_20.christmasRaces.entities.drivers;

import _23_PastExams._2021_12_December_20.christmasRaces.entities.cars.Car;

import static _23_PastExams._2021_12_December_20.christmasRaces.common.ExceptionMessages.CAR_INVALID;
import static _23_PastExams._2021_12_December_20.christmasRaces.common.ExceptionMessages.INVALID_NAME;

public class DriverImpl implements Driver{
    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate;

    public DriverImpl(String name) {
        this.setName(name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Car getCar() {
        return this.car;
    }

    @Override
    public int getNumberOfWins() {
        return this.numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        if (null == car) {
            throw new IllegalArgumentException(CAR_INVALID);
        }

        this.car = car;
        this.canParticipate = true;
    }

    @Override
    public void winRace() {
        this.numberOfWins++;
    }

    @Override
    public boolean getCanParticipate() {
        return this.canParticipate;
    }

    private void setName(String name) {
        if (null == name || name.trim().isEmpty() || name.length() < 5) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, 5));
        }

        this.name = name;
    }
}
