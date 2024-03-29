package _23_PastExams._2023_12_December_09.harpoonDiver.models.diver;

import _23_PastExams._2023_12_December_09.harpoonDiver.common.ExceptionMessages;
import _23_PastExams._2023_12_December_09.harpoonDiver.models.seaCatch.BaseSeaCatch;
import _23_PastExams._2023_12_December_09.harpoonDiver.models.seaCatch.SeaCatch;

public abstract class BaseDiver implements Diver{
    private String name;
    private double oxygen;
    private SeaCatch seaCatch;

    public BaseDiver(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.seaCatch = new BaseSeaCatch();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    @Override
    public boolean canDive() {
        return this.getOxygen() > 0;
    }

    @Override
    public SeaCatch getSeaCatch() {
        return this.seaCatch;
    }

    @Override
    public void shoot() {
        double newOxygenValue =
                this.getOxygen() - 30 < 0 ?
                        0 : this.getOxygen() - 30;

        this.setOxygen(newOxygenValue);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.DIVER_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    private void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(ExceptionMessages.DIVER_OXYGEN_LESS_THAN_ZERO);
        }

        this.oxygen = oxygen;
    }
}
