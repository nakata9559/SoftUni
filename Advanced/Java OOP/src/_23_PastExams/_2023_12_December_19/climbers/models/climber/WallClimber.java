package _23_PastExams._2023_12_December_19.climbers.models.climber;

public class WallClimber extends BaseClimber{
    private static final double INITIAL_STRENGTH = 90;
    private static final double CLIMB_STRENGTH_DECREASE = 30;

    public WallClimber(String name) {
        super(name, INITIAL_STRENGTH);
    }

    @Override
    public void climb() {
        double newStrengthValue = this.getStrength() - CLIMB_STRENGTH_DECREASE;

        if (newStrengthValue < 0) {
            newStrengthValue = 0;
        }

        super.setStrength(newStrengthValue);
    }
}
