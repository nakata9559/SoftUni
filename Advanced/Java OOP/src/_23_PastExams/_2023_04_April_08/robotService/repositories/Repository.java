package _23_PastExams._2023_04_April_08.robotService.repositories;

import _23_PastExams._2023_04_April_08.robotService.entities.supplements.Supplement;

public interface Repository {

    void addSupplement(Supplement supplement);

    boolean removeSupplement(Supplement supplement);

    Supplement findFirst(String type);
}
