package _23_PastExams._2022_12_December_10.christmasPastryShop.repositories;

import _23_PastExams._2022_12_December_10.christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import _23_PastExams._2022_12_December_10.christmasPastryShop.repositories.interfaces.CocktailRepository;

public class CocktailRepositoryImpl<T> extends BaseRepository<Cocktail> implements CocktailRepository<Cocktail> {

    @Override
    public Cocktail getByName(String name) {
        return super.getAll().stream()
                .filter(cocktail -> cocktail.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
