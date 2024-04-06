package _23_PastExams._2023_08_August_15.handball.entities.gameplay;

import _23_PastExams._2023_08_August_15.handball.entities.team.Team;

import static _23_PastExams._2023_08_August_15.handball.common.ConstantMessages.GAMEPLAY_NOT_SUITABLE;

public class Outdoor extends BaseGameplay{
    private static final int CAPACITY = 150;

    public Outdoor(String name) {
        super(name, CAPACITY);
    }

    @Override
    public void addTeam(Team team) {
        if (team.getClass().getSimpleName().equals("Bulgaria")) {
            super.addTeam(team);
        } else {
            throw new IllegalArgumentException(GAMEPLAY_NOT_SUITABLE);
        }
    }
}
