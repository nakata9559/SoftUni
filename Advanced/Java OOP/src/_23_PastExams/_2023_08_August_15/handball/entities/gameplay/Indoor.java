package _23_PastExams._2023_08_August_15.handball.entities.gameplay;

import _23_PastExams._2023_08_August_15.handball.entities.team.Team;

import static _23_PastExams._2023_08_August_15.handball.common.ConstantMessages.GAMEPLAY_NOT_SUITABLE;

public class Indoor extends BaseGameplay{
    private static final int CAPACITY = 250;

    public Indoor(String name) {
        super(name, CAPACITY);
    }

    @Override
    public void addTeam(Team team) {
        if (team.getClass().getSimpleName().equals("Germany")) {
            super.addTeam(team);
        } else {
            throw new IllegalArgumentException(GAMEPLAY_NOT_SUITABLE);
        }
    }
}
