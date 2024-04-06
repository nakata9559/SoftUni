package _23_PastExams._2022_12_December_10.christmasPastryShop.repositories;

import _23_PastExams._2022_12_December_10.christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import _23_PastExams._2022_12_December_10.christmasPastryShop.repositories.interfaces.DelicacyRepository;

public class DelicacyRepositoryImpl<T> extends BaseRepository<Delicacy> implements DelicacyRepository<Delicacy> {

    @Override
    public Delicacy getByName(String name) {
        return super.getAll().stream()
                .filter(delicacy -> delicacy.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
