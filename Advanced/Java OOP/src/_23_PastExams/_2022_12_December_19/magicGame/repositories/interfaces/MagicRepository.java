package _23_PastExams._2022_12_December_19.magicGame.repositories.interfaces;

import _23_PastExams._2022_12_December_19.magicGame.models.magics.Magic;

import java.util.Collection;

public interface MagicRepository<T> {
    Collection<T> getData();

    void addMagic(Magic model);

    boolean removeMagic(Magic model);

    T findByName(String name);
}
