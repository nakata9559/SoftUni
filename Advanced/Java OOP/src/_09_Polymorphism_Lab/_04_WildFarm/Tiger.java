package _09_Polymorphism_Lab._04_WildFarm;

public class Tiger extends Feline{

    protected Tiger(String animalType,
                    String animalName,
                    Double animalWeight,
                    String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    protected void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    protected void eat(Food food) {
        if (food instanceof Meat) {
            super.setFoodEaten(food.getQuantity());

        } else {
            System.out.println("Tigers are not eating that type of food!");
        }
    }
}
