package _23_PastExams._2021_12_December_20.christmasRaces.core;

import _23_PastExams._2021_12_December_20.christmasRaces.entities.drivers.Driver;
import _23_PastExams._2021_12_December_20.christmasRaces.entities.races.Race;
import _23_PastExams._2021_12_December_20.christmasRaces.repositories.interfaces.Repository;
import _23_PastExams._2021_12_December_20.christmasRaces.core.interfaces.Controller;
import _23_PastExams._2021_12_December_20.christmasRaces.entities.cars.Car;
import _23_PastExams._2021_12_December_20.christmasRaces.entities.cars.MuscleCar;
import _23_PastExams._2021_12_December_20.christmasRaces.entities.cars.SportsCar;
import _23_PastExams._2021_12_December_20.christmasRaces.entities.drivers.DriverImpl;
import _23_PastExams._2021_12_December_20.christmasRaces.entities.races.RaceImpl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static _23_PastExams._2021_12_December_20.christmasRaces.common.ExceptionMessages.*;
import static _23_PastExams._2021_12_December_20.christmasRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        if (driverRepository.getByName(driver) != null) {
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver));
        }

        this.driverRepository.add(new DriverImpl(driver));

        return String.format(DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = null;

        switch (type) {
            case "Muscle":
                car = new MuscleCar(model, horsePower);
                break;

            case "Sports":
                car = new SportsCar(model, horsePower);
                break;
        }

        if (this.carRepository.getByName(model) != null) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }

        this.carRepository.add(car);

        assert car != null;
        return String.format(CAR_CREATED, car.getClass().getSimpleName(), model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Car car = this.carRepository.getByName(carModel);
        Driver driver = this.driverRepository.getByName(driverName);

        if (null == driver) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }

        if (null == car) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }

        driver.addCar(car);

        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race race = this.raceRepository.getByName(raceName);
        Driver driver = this.driverRepository.getByName(driverName);

        if (null == race) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }

        if (null == driver) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }

        race.addDriver(driver);

        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = this.raceRepository.getByName(raceName);

        if (null == race) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }

        List<Driver> drivers =
                this.driverRepository.getAll()
                        .stream()
                        .filter(Driver::getCanParticipate)
                        .sorted(Comparator.comparing(driver -> driver.getCar()
                                .calculateRacePoints(race.getLaps())))
                        .collect(Collectors.toList());

        Collections.reverse(drivers);

        if (drivers.size() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }

        return String.format(DRIVER_FIRST_POSITION + System.lineSeparator() +
                        DRIVER_SECOND_POSITION + System.lineSeparator() +
                        DRIVER_THIRD_POSITION,
                drivers.get(0).getName(),
                raceName,
                drivers.get(1).getName(),
                raceName,
                drivers.get(2).getName(),
                raceName);
    }

    @Override
    public String createRace(String name, int laps) {
        if (raceRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }

        this.raceRepository.add(new RaceImpl(name, laps));

        return String.format(RACE_CREATED, name);
    }
}
