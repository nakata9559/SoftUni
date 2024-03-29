package _23_PastExams._2023_12_December_19.climbers.models.climber;

public class RockClimber extends BaseClimber{
    private static final double INITIAL_STRENGTH = 120;
    private static final double CLIMB_STRENGTH_DECREASE = 60;

    public RockClimber(String name) {
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
