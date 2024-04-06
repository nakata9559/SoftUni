package _23_PastExams._2023_04_April_18.vehicleShop.models.tool;

import _23_PastExams._2023_04_April_18.vehicleShop.common.ExceptionMessages;

public class ToolImpl implements Tool{
    private static final int DECREASE_POWER = 5;
    private int power;

    public ToolImpl(int power) {
        this.setPower(power);
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public void decreasesPower() {
        this.power = Math.max(0, this.power - DECREASE_POWER);
    }

    @Override
    public boolean isUnfit() {
        return this.power == 0;
    }

    private void setPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException(ExceptionMessages.TOOL_POWER_LESS_THAN_ZERO);
        }

        this.power = power;
    }
}
