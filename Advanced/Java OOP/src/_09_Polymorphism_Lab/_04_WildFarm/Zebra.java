package _09_Polymorphism_Lab._04_WildFarm;

public class Zebra extends Mammal{

    protected Zebra(String animalType,
                    String animalName,
                    Double animalWeight,
                    String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    protected void makeSound() {
        System.out.println("Zs");
    }

    @Override
    protected void eat(Food food) {
        if (food instanceof Vegetable) {
            super.setFoodEaten(food.getQuantity());

        } else {
            System.out.println("Zebras are not eating that type of food!");
        }
    }
}
