package _09_Polymorphism_Lab._04_WildFarm;

public class Mouse extends Mammal{

    protected Mouse(String animalType,
                    String animalName,
                    Double animalWeight,
                    String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    protected void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    protected void eat(Food food) {
        if (food instanceof Vegetable) {
            super.setFoodEaten(food.getQuantity());

        } else {
            System.out.println("Mice are not eating that type of food!");
        }
    }
}
