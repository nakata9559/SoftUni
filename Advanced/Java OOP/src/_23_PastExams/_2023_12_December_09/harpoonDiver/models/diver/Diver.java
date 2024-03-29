package _23_PastExams._2023_12_December_09.harpoonDiver.models.diver;

import _23_PastExams._2023_12_December_09.harpoonDiver.models.seaCatch.SeaCatch;

public interface Diver {
    String getName();

    double getOxygen();

    boolean canDive();

    SeaCatch getSeaCatch();

    void shoot();
}
