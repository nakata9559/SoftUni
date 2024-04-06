package _23_PastExams._2022_12_December_10.christmasPastryShop.repositories;

import _23_PastExams._2022_12_December_10.christmasPastryShop.entities.booths.interfaces.Booth;
import _23_PastExams._2022_12_December_10.christmasPastryShop.repositories.interfaces.BoothRepository;

public class BoothRepositoryImpl<T> extends BaseRepository<Booth> implements BoothRepository<Booth> {

    @Override
    public Booth getByNumber(int number) {
        return super.getAll().stream()
                .filter(booth -> booth.getBoothNumber() == number)
                .findFirst()
                .orElse(null);
    }
}
