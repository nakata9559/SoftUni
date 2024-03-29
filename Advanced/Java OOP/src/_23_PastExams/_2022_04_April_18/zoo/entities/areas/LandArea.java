package _23_PastExams._2022_04_April_18.zoo.entities.areas;

import _23_PastExams._2022_04_April_18.zoo.common.ConstantMessages;
import _23_PastExams._2022_04_April_18.zoo.entities.animals.Animal;

public class LandArea extends BaseArea{
    private static final int CAPACITY = 25;
    public LandArea(String name) {
        super(name, CAPACITY);
    }

    @Override
    public void addAnimal(Animal animal) {
        if (animal.getClass().getSimpleName().equals("TerrestrialAnimal")) {
            super.addAnimal(animal);

        } else {
            throw new IllegalArgumentException(ConstantMessages.AREA_NOT_SUITABLE);
        }
    }
}
