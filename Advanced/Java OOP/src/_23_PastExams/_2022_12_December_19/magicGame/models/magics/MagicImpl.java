package _23_PastExams._2022_12_December_19.magicGame.models.magics;

import _23_PastExams._2022_12_December_19.magicGame.common.ExceptionMessages;

public abstract class MagicImpl implements Magic{
    private String name;
    private int bulletsCount;

    public MagicImpl(String name, int bulletsCount) {
        this.setName(name);
        this.setBulletsCount(bulletsCount);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsCount() {
        return this.bulletsCount;
    }

    @Override
    public abstract int fire();

    private void setName(String name) {
        if (null == name || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC_NAME);
        }

        this.name = name;
    }

    protected void setBulletsCount(int bulletsCount) {
        if (bulletsCount < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGIC_BULLETS_COUNT);
        }

        this.bulletsCount = bulletsCount;
    }
}
