package _23_PastExams._2021_12_December_20.christmasRaces.entities.races;

import _23_PastExams._2021_12_December_20.christmasRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;

import static _23_PastExams._2021_12_December_20.christmasRaces.common.ExceptionMessages.*;

public class RaceImpl implements Race{
    private String name;
    private int laps;
    private Collection<Driver> drivers;

    public RaceImpl(String name, int laps) {
        this.setName(name);
        this.setLaps(laps);
        this.drivers = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return this.drivers;
    }

    @Override
    public void addDriver(Driver driver) {
        if (null == driver) {
            throw new IllegalArgumentException(DRIVER_INVALID);

        } else if (!driver.getCanParticipate()) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_PARTICIPATE, driver.getName()));

        } else if (this.drivers.contains(driver)) {
            throw new IllegalArgumentException(String.format(DRIVER_ALREADY_ADDED, driver.getName(), this.name));
        }

        this.drivers.add(driver);
    }

    private void setName(String name) {
        if (null == name || name.trim().isEmpty() || name.length() < 5) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, 5));
        }

        this.name = name;

    }

    private void setLaps(int laps) {
        if (laps < 1) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_LAPS, 1));
        }

        this.laps = laps;
    }
}
