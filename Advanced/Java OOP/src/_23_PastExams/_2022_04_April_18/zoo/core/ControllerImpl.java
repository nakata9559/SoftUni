package _23_PastExams._2022_04_April_18.zoo.core;

import _23_PastExams._2022_04_April_18.zoo.common.ConstantMessages;
import _23_PastExams._2022_04_April_18.zoo.common.ExceptionMessages;
import _23_PastExams._2022_04_April_18.zoo.entities.animals.Animal;
import _23_PastExams._2022_04_April_18.zoo.entities.areas.Area;
import _23_PastExams._2022_04_April_18.zoo.entities.areas.LandArea;
import _23_PastExams._2022_04_April_18.zoo.entities.areas.WaterArea;
import _23_PastExams._2022_04_April_18.zoo.entities.foods.Food;
import _23_PastExams._2022_04_April_18.zoo.entities.foods.Meat;
import _23_PastExams._2022_04_April_18.zoo.entities.foods.Vegetable;
import _23_PastExams._2022_04_April_18.zoo.repositories.FoodRepository;
import _23_PastExams._2022_04_April_18.zoo.repositories.FoodRepositoryImpl;
import _23_PastExams._2022_04_April_18.zoo.entities.animals.AquaticAnimal;
import _23_PastExams._2022_04_April_18.zoo.entities.animals.TerrestrialAnimal;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private static final Food VEGETABLE = new Vegetable();
    private static final Food MEAT = new Meat();
    private FoodRepository foodRepository;
    private Collection<Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new ArrayList<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        switch (areaType) {
            case "WaterArea":
                this.areas.add(new WaterArea(areaName));
                break;

            case "LandArea":
                this.areas.add(new LandArea(areaName));
                break;

            default:
                throw new NullPointerException(ExceptionMessages.INVALID_AREA_TYPE);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        switch (foodType) {
            case "Vegetable":
                this.foodRepository.add(VEGETABLE);
                break;

            case "Meat":
                this.foodRepository.add(MEAT);
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_FOOD_TYPE);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food food;

        switch (foodType){
            case "Vegetable":
                food = VEGETABLE;
                break;

            case "Meat":
                food = MEAT;
                break;

            default:
                throw new IllegalArgumentException(String.format(ExceptionMessages.NO_FOOD_FOUND, foodType));
        }

        if (this.foodRepository.remove(food)) {
            this.areas.stream()
                    .filter(area -> area.getName().equals(areaName))
                    .forEach(area -> area.addFood(food));
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Animal animal;

        switch (animalType) {
            case "AquaticAnimal":
                animal = new AquaticAnimal(animalName, kind, price);
                break;

            case "TerrestrialAnimal":
                animal = new TerrestrialAnimal(animalName, kind, price);
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_ANIMAL_TYPE);
        }

        this.areas.stream()
                .filter(area -> area.getName().equals(areaName))
                .forEach(area -> area.addAnimal(animal));

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
    }

    @Override
    public String feedAnimal(String areaName) {
        Area currentArea = this.areas.stream()
                .filter(area -> area.getName().equals(areaName))
                .findFirst()
                .orElse(null);

        assert currentArea != null;
        currentArea.feed();

        return String.format(ConstantMessages.ANIMALS_FED, currentArea.getAnimals().size());
    }

    @Override
    public String calculateKg(String areaName) {
        Area currentArea = this.areas.stream()
                .filter(area -> area.getName().equals(areaName))
                .findFirst()
                .orElse(null);

        assert currentArea != null;
        double sumOfKilograms = currentArea.getAnimals()
                .stream().mapToDouble(Animal::getKg)
                .sum();

        return String.format(ConstantMessages.KILOGRAMS_AREA, areaName, sumOfKilograms);
    }

    @Override
    public String getStatistics() {
        return String.join(System.lineSeparator(),
                this.areas.stream()
                        .map(Area::getInfo)
                        .toArray(String[]::new));
    }
}
