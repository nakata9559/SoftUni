package _23_PastExams._2021_12_December_20.christmasRaces.entities.drivers;

import _23_PastExams._2021_12_December_20.christmasRaces.entities.cars.Car;

public interface Driver {
    String getName();

    Car getCar();

    int getNumberOfWins();

    void addCar(Car car);

    void winRace();

    boolean getCanParticipate();
}
