package _23_PastExams._2021_12_December_20.christmasRaces;

import _23_PastExams._2021_12_December_20.christmasRaces.io.ConsoleWriter;
import _23_PastExams._2021_12_December_20.christmasRaces.repositories.interfaces.Repository;
import _23_PastExams._2021_12_December_20.christmasRaces.core.ControllerImpl;
import _23_PastExams._2021_12_December_20.christmasRaces.core.EngineImpl;
import _23_PastExams._2021_12_December_20.christmasRaces.core.interfaces.Controller;
import _23_PastExams._2021_12_December_20.christmasRaces.entities.cars.Car;
import _23_PastExams._2021_12_December_20.christmasRaces.entities.drivers.Driver;
import _23_PastExams._2021_12_December_20.christmasRaces.entities.races.Race;
import _23_PastExams._2021_12_December_20.christmasRaces.io.ConsoleReader;
import _23_PastExams._2021_12_December_20.christmasRaces.repositories.CarRepository;
import _23_PastExams._2021_12_December_20.christmasRaces.repositories.DriverRepository;
import _23_PastExams._2021_12_December_20.christmasRaces.repositories.RaceRepository;

public class Main {
    public static void main(String[] args) {
        Repository<Car> carRepository = new CarRepository();
        Repository<Race> raceRepository = new RaceRepository();
        Repository<Driver> driverRepository = new DriverRepository();

        Controller controller = new ControllerImpl(driverRepository, carRepository, raceRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}
