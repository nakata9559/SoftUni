package _23_PastExams._2022_12_December_19.magicGame.repositories.interfaces;

import _23_PastExams._2022_12_December_19.magicGame.models.magicians.Magician;

import java.util.Collection;

public interface MagicianRepository<T> {
    Collection<T> getData();

    void addMagician(Magician model);

    boolean removeMagician(Magician model);

    T findByUsername(String name);
}
