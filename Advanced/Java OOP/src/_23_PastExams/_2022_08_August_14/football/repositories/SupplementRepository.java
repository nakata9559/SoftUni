package _23_PastExams._2022_08_August_14.football.repositories;

import _23_PastExams._2022_08_August_14.football.entities.supplement.Supplement;

public interface SupplementRepository {
    void add(Supplement supplement);

    boolean remove(Supplement supplement);

    Supplement findByType(String type);
}
