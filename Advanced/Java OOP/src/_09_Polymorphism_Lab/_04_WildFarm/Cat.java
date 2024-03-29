package _09_Polymorphism_Lab._04_WildFarm;

import java.text.DecimalFormat;

public class Cat extends Feline{
    private String breed;

    protected Cat(String animalType,
                  String animalName,
                  Double animalWeight,
                  String livingRegion,
                  String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.breed = breed;
    }

    protected String getBreed() {
        return breed;
    }

    @Override
    protected void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    protected void eat(Food food) {
        if (food instanceof Vegetable ||
                food instanceof Meat) {
            super.setFoodEaten(food.getQuantity());

        } else {
            System.out.println("Cats are not eating that type of food!");
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]",
                super.getAnimalType(),
                super.getAnimalName(),
                this.getBreed(),
                df.format(super.getAnimalWeight()),
                super.getLivingRegion(),
                super.getFoodEaten());
    }
}
