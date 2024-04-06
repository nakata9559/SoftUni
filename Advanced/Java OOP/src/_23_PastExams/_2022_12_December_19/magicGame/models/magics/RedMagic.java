package _23_PastExams._2022_12_December_19.magicGame.models.magics;

public class RedMagic extends MagicImpl{
    private static final int FIRE_BULLETS_AT_ONCE = 1;

    public RedMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() - FIRE_BULLETS_AT_ONCE < 0) {
            return 0;
        }

        super.setBulletsCount(super.getBulletsCount() - FIRE_BULLETS_AT_ONCE);
        return FIRE_BULLETS_AT_ONCE;
    }
}
