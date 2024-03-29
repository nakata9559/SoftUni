package _23_PastExams._2023_12_December_19.climbers.models.climber;

import _23_PastExams._2023_12_December_19.climbers.models.roster.Roster;

public interface Climber {
    String getName();

    double getStrength();

    boolean canClimb();

    Roster getRoster();


    void climb();
}
