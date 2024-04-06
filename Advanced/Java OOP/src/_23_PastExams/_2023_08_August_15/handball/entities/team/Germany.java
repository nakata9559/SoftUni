package _23_PastExams._2023_08_August_15.handball.entities.team;

public class Germany extends BaseTeam{
    private static final int ADVANTAGE_INCREASE = 145;

    public Germany(String name, String country, int advantage) {
        super(name, country, advantage);
    }

    @Override
    public void play() {
        super.setAdvantage(super.getAdvantage() + ADVANTAGE_INCREASE);
    }
}
