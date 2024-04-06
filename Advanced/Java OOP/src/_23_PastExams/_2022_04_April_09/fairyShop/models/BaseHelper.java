package _23_PastExams._2022_04_April_09.fairyShop.models;

import java.util.ArrayList;
import java.util.Collection;

import static _23_PastExams._2022_04_April_09.fairyShop.common.ExceptionMessages.HELPER_NAME_NULL_OR_EMPTY;

public abstract class BaseHelper implements Helper{
    private static final int WORK_ENERGY_DECREASE = 10;
    private String name;
    private int energy;
    private Collection<Instrument> instruments;

    public BaseHelper(String name, int energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.instruments = new ArrayList<>();
    }

    @Override
    public void work() {
        this.setEnergy(Math.max(0, this.energy - WORK_ENERGY_DECREASE));
    }

    @Override
    public void addInstrument(Instrument instrument) {
        this.instruments.add(instrument);
    }

    @Override
    public boolean canWork() {
        return this.energy > 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return this.instruments;
    }

    protected void setEnergy(int energy) {
        this.energy = energy;
    }

    private void setName(String name) {
        if (null == name || name.trim().isEmpty()) {
            throw new NullPointerException(HELPER_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }
}
