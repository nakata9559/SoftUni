package _23_PastExams._2022_12_December_19.magicGame.repositories;

import _23_PastExams._2022_12_December_19.magicGame.common.ExceptionMessages;
import _23_PastExams._2022_12_December_19.magicGame.models.magics.Magic;
import _23_PastExams._2022_12_December_19.magicGame.repositories.interfaces.MagicRepository;

import java.util.ArrayList;
import java.util.Collection;

public class MagicRepositoryImpl<T> implements MagicRepository<Magic> {
    private Collection<Magic> data;

    public MagicRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    @Override
    public Collection<Magic> getData() {
        return this.data;
    }

    @Override
    public void addMagic(Magic model) {
        if (null == model) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC_REPOSITORY);
        }

        this.data.add(model);
    }

    @Override
    public boolean removeMagic(Magic model) {
        return this.data.remove(model);
    }

    @Override
    public Magic findByName(String name) {
        return this.data.stream()
                .filter(magic -> magic.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
