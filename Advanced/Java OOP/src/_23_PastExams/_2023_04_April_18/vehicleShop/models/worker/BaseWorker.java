package _23_PastExams._2023_04_April_18.vehicleShop.models.worker;

import _23_PastExams._2023_04_April_18.vehicleShop.common.ExceptionMessages;
import _23_PastExams._2023_04_April_18.vehicleShop.models.tool.Tool;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseWorker implements Worker{
    private static final int WORKING_STRENGTH_DECREASE = 10;
    private String name;
    private int strength;
    private Collection<Tool> tools;

    public BaseWorker(String name, int strength) {
        this.setName(name);
        this.setStrength(strength);
        this.tools = new ArrayList<>();
    }

    @Override
    public void working() {
        this.strength = Math.max(0, this.strength - WORKING_STRENGTH_DECREASE);
    }

    @Override
    public void addTool(Tool tool) {
        this.tools.add(tool);
    }

    @Override
    public boolean canWork() {
        return this.strength > 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public Collection<Tool> getTools() {
        return this.tools;
    }

    private void setName(String name) {
        if (null == name || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.WORKER_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    private void setStrength(int strength) {
        if (strength < 0) {
            throw new IllegalArgumentException(ExceptionMessages.WORKER_STRENGTH_LESS_THAN_ZERO);
        }

        this.strength = strength;
    }
}
