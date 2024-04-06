package _23_PastExams._2021_12_December_20.christmasRaces.entities.cars;

public interface Car {
    String getModel();

    int getHorsePower();

    double getCubicCentimeters();

    double calculateRacePoints(int laps);
}
