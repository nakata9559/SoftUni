package _23_PastExams._2022_04_April_09.fairyShop.models;

import static _23_PastExams._2022_04_April_09.fairyShop.common.ExceptionMessages.PRESENT_ENERGY_LESS_THAN_ZERO;
import static _23_PastExams._2022_04_April_09.fairyShop.common.ExceptionMessages.PRESENT_NAME_NULL_OR_EMPTY;

public class PresentImpl implements Present{
    private static final int GET_CRAFTED_ENERGY_REQUIRED_DECREASE = 10;
    private String name;
    private int energyRequired;

    public PresentImpl(String name, int energyRequired) {
        this.setName(name);
        this.setEnergyRequired(energyRequired);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergyRequired() {
        return this.energyRequired;
    }

    @Override
    public boolean isDone() {
        return this.getEnergyRequired() == 0;
    }

    @Override
    public void getCrafted() {
        this.setEnergyRequired(Math.max(0, this.getEnergyRequired() - GET_CRAFTED_ENERGY_REQUIRED_DECREASE));
    }

    private void setName(String name) {
        if (null == name || name.trim().isEmpty()) {
            throw new NullPointerException(PRESENT_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    private void setEnergyRequired(int energyRequired) {
        if (energyRequired < 0) {
            throw new IllegalArgumentException(PRESENT_ENERGY_LESS_THAN_ZERO);
        }

        this.energyRequired = energyRequired;
    }
}
