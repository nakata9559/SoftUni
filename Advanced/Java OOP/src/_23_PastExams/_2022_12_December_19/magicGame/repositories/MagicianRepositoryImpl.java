package _23_PastExams._2022_12_December_19.magicGame.repositories;

import _23_PastExams._2022_12_December_19.magicGame.common.ExceptionMessages;
import _23_PastExams._2022_12_December_19.magicGame.models.magicians.Magician;
import _23_PastExams._2022_12_December_19.magicGame.repositories.interfaces.MagicianRepository;

import java.util.ArrayList;
import java.util.Collection;

public class MagicianRepositoryImpl<T> implements MagicianRepository<Magician> {
    private Collection<Magician> data;

    public MagicianRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    @Override
    public Collection<Magician> getData() {
        return this.data;
    }

    @Override
    public void addMagician(Magician model) {
        if (null == model) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_REPOSITORY);
        }

        this.data.add(model);
    }

    @Override
    public boolean removeMagician(Magician model) {
        return this.data.remove(model);
    }

    @Override
    public Magician findByUsername(String name) {
        return this.data.stream()
                .filter(magician -> magician.getUsername().equals(name))
                .findFirst()
                .orElse(null);
    }
}
