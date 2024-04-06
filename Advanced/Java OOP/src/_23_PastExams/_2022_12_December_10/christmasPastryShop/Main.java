package _23_PastExams._2022_12_December_10.christmasPastryShop;

import _23_PastExams._2022_12_December_10.christmasPastryShop.core.ControllerImpl;
import _23_PastExams._2022_12_December_10.christmasPastryShop.core.EngineImpl;
import _23_PastExams._2022_12_December_10.christmasPastryShop.core.interfaces.Controller;
import _23_PastExams._2022_12_December_10.christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import _23_PastExams._2022_12_December_10.christmasPastryShop.io.ConsoleReader;
import _23_PastExams._2022_12_December_10.christmasPastryShop.io.ConsoleWriter;
import _23_PastExams._2022_12_December_10.christmasPastryShop.repositories.DelicacyRepositoryImpl;
import _23_PastExams._2022_12_December_10.christmasPastryShop.repositories.interfaces.BoothRepository;
import _23_PastExams._2022_12_December_10.christmasPastryShop.repositories.interfaces.CocktailRepository;
import _23_PastExams._2022_12_December_10.christmasPastryShop.repositories.interfaces.DelicacyRepository;
import _23_PastExams._2022_12_December_10.christmasPastryShop.entities.booths.interfaces.Booth;
import _23_PastExams._2022_12_December_10.christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import _23_PastExams._2022_12_December_10.christmasPastryShop.repositories.BoothRepositoryImpl;
import _23_PastExams._2022_12_December_10.christmasPastryShop.repositories.CocktailRepositoryImpl;

public class Main {
    public static void main(String[] args) {

        DelicacyRepository<Delicacy> delicacyRepository = new DelicacyRepositoryImpl<>();
        CocktailRepository<Cocktail> cocktailRepository = new CocktailRepositoryImpl<>();
        BoothRepository<Booth> boothRepository = new BoothRepositoryImpl<>();

        Controller controller = new ControllerImpl(delicacyRepository, cocktailRepository, boothRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();

    }
}
