package _07_InterfacesAndAbstraction_Lab._02_CarShopExtended;

public interface Rentable extends Car {
    Integer getMinRentDay();
    Double getPricePerDay();
}
