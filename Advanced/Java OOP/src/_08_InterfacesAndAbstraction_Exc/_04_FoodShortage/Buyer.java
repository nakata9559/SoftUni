package _08_InterfacesAndAbstraction_Exc._04_FoodShortage;

public interface Buyer extends Person {
    void buyFood();
    int getFood();

    @Override
    String getName();

    @Override
    int getAge();
}
