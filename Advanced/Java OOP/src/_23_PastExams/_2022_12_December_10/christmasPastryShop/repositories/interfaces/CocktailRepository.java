package _23_PastExams._2022_12_December_10.christmasPastryShop.repositories.interfaces;

public interface CocktailRepository<T> extends Repository<T> {
    T getByName(String name);
}
