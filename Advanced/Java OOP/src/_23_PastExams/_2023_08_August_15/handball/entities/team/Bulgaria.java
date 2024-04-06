package _23_PastExams._2023_08_August_15.handball.entities.team;

public class Bulgaria extends BaseTeam{
    private static final int ADVANTAGE_INCREASE = 115;

    public Bulgaria(String name, String country, int advantage) {
        super(name, country, advantage);
    }

    @Override
    public void play() {
        super.setAdvantage(super.getAdvantage() + ADVANTAGE_INCREASE);
    }
}
