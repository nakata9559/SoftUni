package _23_PastExams._2022_12_December_10.christmasPastryShop.core;

import _23_PastExams._2022_12_December_10.christmasPastryShop.entities.booths.OpenBooth;
import _23_PastExams._2022_12_December_10.christmasPastryShop.entities.booths.PrivateBooth;
import _23_PastExams._2022_12_December_10.christmasPastryShop.entities.cocktails.Hibernation;
import _23_PastExams._2022_12_December_10.christmasPastryShop.entities.cocktails.MulledWine;
import _23_PastExams._2022_12_December_10.christmasPastryShop.entities.delicacies.Gingerbread;
import _23_PastExams._2022_12_December_10.christmasPastryShop.core.interfaces.Controller;
import _23_PastExams._2022_12_December_10.christmasPastryShop.entities.booths.interfaces.Booth;
import _23_PastExams._2022_12_December_10.christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import _23_PastExams._2022_12_December_10.christmasPastryShop.entities.delicacies.Stolen;
import _23_PastExams._2022_12_December_10.christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import _23_PastExams._2022_12_December_10.christmasPastryShop.repositories.interfaces.BoothRepository;
import _23_PastExams._2022_12_December_10.christmasPastryShop.repositories.interfaces.CocktailRepository;
import _23_PastExams._2022_12_December_10.christmasPastryShop.repositories.interfaces.DelicacyRepository;

import static _23_PastExams._2022_12_December_10.christmasPastryShop.common.ExceptionMessages.BOOTH_EXIST;
import static _23_PastExams._2022_12_December_10.christmasPastryShop.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static _23_PastExams._2022_12_December_10.christmasPastryShop.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;
    private double totalStoreIncome;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
    }


    @Override
    public String addDelicacy(String type, String name, double price) {
        if (this.delicacyRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        switch (type) {
            case "Gingerbread":
                this.delicacyRepository.add(new Gingerbread(name, price));
                break;

            case "Stolen":
                this.delicacyRepository.add(new Stolen(name, price));
                break;
        }

        return String.format(DELICACY_ADDED, name, type);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        if (this.cocktailRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        switch (type) {
            case "MulledWine":
                this.cocktailRepository.add(new MulledWine(name, size, brand));
                break;

            case "Hibernation":
                this.cocktailRepository.add(new Hibernation(name, size, brand));
                break;
        }

        return String.format(COCKTAIL_ADDED, name, brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        if (this.boothRepository.getByNumber(boothNumber) != null) {
            throw new IllegalArgumentException(String.format(BOOTH_EXIST, boothNumber));
        }

        switch (type) {
            case "OpenBooth":
                this.boothRepository.add(new OpenBooth(boothNumber, capacity));
                break;

            case "PrivateBooth":
                this.boothRepository.add(new PrivateBooth(boothNumber, capacity));
                break;
        }

        return String.format(BOOTH_ADDED, boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        Booth currentBooth = this.boothRepository.getAll()
                .stream()
                .filter(booth -> !booth.isReserved())
                .filter(booth -> booth.getCapacity() >= numberOfPeople)
                .findFirst()
                .orElse(null);

        if (currentBooth == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }

        currentBooth.reserve(numberOfPeople);

        return String.format(BOOTH_RESERVED,
                currentBooth.getBoothNumber(),
                numberOfPeople);
    }

    @Override
    public String leaveBooth(int boothNumber) {
        Booth booth = this.boothRepository.getByNumber(boothNumber);

        double boothBill = booth.getBill();
        this.totalStoreIncome += boothBill;
        booth.clear();

        return String.format(BILL,
                boothNumber,
                boothBill);
    }

    @Override
    public String getIncome() {
        return String.format(TOTAL_INCOME,
                this.totalStoreIncome);
    }
}
