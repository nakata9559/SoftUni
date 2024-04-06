package _23_PastExams._2022_12_December_10.christmasPastryShop.repositories.interfaces;

public interface BoothRepository<T> extends Repository<T> {
    T getByNumber(int number);
}
