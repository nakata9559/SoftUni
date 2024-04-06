package _23_PastExams._2022_08_August_14.football.entities.player;

public class Men extends BasePlayer{
    private static final int STIMULATION_INCREASE = 145;
    private static final double INITIAL_KILOGRAMS = 85.5;

    public Men(String name, String nationality, int strength) {
        super(name, nationality, INITIAL_KILOGRAMS, strength);
    }

//    @Override
//    public void stimulation() {
//        super.setStrength(super.getStrength() + STIMULATION_INCREASE);
//    }
}
