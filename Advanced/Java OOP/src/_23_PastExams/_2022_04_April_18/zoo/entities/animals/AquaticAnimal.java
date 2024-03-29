package _23_PastExams._2022_04_April_18.zoo.entities.animals;

public class AquaticAnimal extends BaseAnimal{
    private static final double INITIAL_KILOGRAMS = 2.5;

    public AquaticAnimal(String name, String kind, double price) {
        super(name, kind, INITIAL_KILOGRAMS, price);
    }

    @Override
    public void eat() {
        super.setKg(super.getKg() + 7.5);
    }
}
