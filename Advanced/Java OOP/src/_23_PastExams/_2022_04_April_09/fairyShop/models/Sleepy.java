package _23_PastExams._2022_04_April_09.fairyShop.models;

public class Sleepy extends BaseHelper{
    private static final int INITIAL_ENERGY = 50;
    private static final int WORK_ENERGY_DECREASE = 15;

    public Sleepy(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void work() {
        super.setEnergy(Math.max(0, super.getEnergy() - WORK_ENERGY_DECREASE));
    }
}
