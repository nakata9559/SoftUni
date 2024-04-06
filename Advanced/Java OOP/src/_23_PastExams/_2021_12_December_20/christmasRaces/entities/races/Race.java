package _23_PastExams._2021_12_December_20.christmasRaces.entities.races;

import _23_PastExams._2021_12_December_20.christmasRaces.entities.drivers.Driver;

import java.util.Collection;

public interface Race {
    String getName();

    int getLaps();

    Collection<Driver> getDrivers();

    void addDriver(Driver driver);
}
