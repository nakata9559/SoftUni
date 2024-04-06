package _23_PastExams._2023_04_April_18.vehicleShop.models.vehicle;

import _23_PastExams._2023_04_April_18.vehicleShop.common.ExceptionMessages;

public class VehicleImpl implements Vehicle{
    private static final int STRENGTH_DECREASE = 5;
    private String name;
    private int strengthRequired;

    public VehicleImpl(String name, int strengthRequired) {
        this.setName(name);
        this.setStrengthRequired(strengthRequired);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrengthRequired() {
        return this.strengthRequired;
    }

    @Override
    public boolean reached() {
        return this.strengthRequired == 0;
    }

    @Override
    public void making() {
        this.strengthRequired = Math.max(0, this.strengthRequired - STRENGTH_DECREASE);
    }

    private void setName(String name) {
        if (null == name || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.VEHICLE_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    private void setStrengthRequired(int strengthRequired) {
        if (strengthRequired < 0) {
            throw new IllegalArgumentException(ExceptionMessages.VEHICLE_STRENGTH_LESS_THAN_ZERO);
        }

        this.strengthRequired = strengthRequired;
    }
}
