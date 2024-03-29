package _09_Polymorphism_Lab._04_WildFarm;

public abstract class Feline extends Mammal{

    protected Feline(String animalType,
                     String animalName,
                     Double animalWeight,
                     String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    protected abstract void makeSound();

    @Override
    protected abstract void eat(Food food);
}
