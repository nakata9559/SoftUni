package _23_PastExams._2022_04_April_09.fairyShop.models;

import static _23_PastExams._2022_04_April_09.fairyShop.common.ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO;

public class InstrumentImpl implements Instrument{
    private static final int USE_POWER_DECREASE = 10;
    private int power;

    public InstrumentImpl(int power) {
        this.setPower(power);
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public void use() {
        this.setPower(Math.max(0, this.getPower() - USE_POWER_DECREASE));
    }

    @Override
    public boolean isBroken() {
        return this.getPower() == 0;
    }

    private void setPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException(INSTRUMENT_POWER_LESS_THAN_ZERO);
        }

        this.power = power;
    }
}
