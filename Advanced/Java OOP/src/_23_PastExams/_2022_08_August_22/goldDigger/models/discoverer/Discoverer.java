package _23_PastExams._2022_08_August_22.goldDigger.models.discoverer;

import _23_PastExams._2022_08_August_22.goldDigger.models.museum.Museum;

public interface Discoverer {
    String getName();

    double getEnergy();

    boolean canDig();

    Museum getMuseum();

    void dig();
}
