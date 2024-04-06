package _23_PastExams._2021_12_December_20.christmasRaces.entities.cars;

import static _23_PastExams._2021_12_December_20.christmasRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class MuscleCar extends BaseCar{
    private static final double CUBIC_CENTIMETERS = 5000;
    private static final int MIN_HORSEPOWER = 400;
    private static final int MAX_HORSEPOWER = 600;

    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, CUBIC_CENTIMETERS);
    }

    @Override
    protected void setHorsePower(int horsePower) {
        if (horsePower < MIN_HORSEPOWER || horsePower > MAX_HORSEPOWER) {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }

        super.setHorsePower(horsePower);
    }
}
