package _23_PastExams._2021_12_December_20.christmasRaces.core.interfaces;

public interface Controller {
    String createDriver(String driver);

    String createCar(String type, String model, int horsePower);

    String addCarToDriver(String driverName, String carModel);

    String addDriverToRace(String raceName, String driverName);

    String startRace(String raceName);

    String createRace(String name, int laps);
}
