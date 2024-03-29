package _06_Inheritance_Exc._04_NeedForSpeed;

public class Main {
    public static void main(String[] args) {
        RaceMotorcycle raceMotorcycle = new RaceMotorcycle(10, 200);
        CrossMotorcycle crossMotorcycle = new CrossMotorcycle(15, 300);
        FamilyCar familyCar = new FamilyCar(20, 80);
        SportCar sportCar = new SportCar(40, 250);

        raceMotorcycle.drive(1);
        System.out.println(raceMotorcycle.getFuel());
        crossMotorcycle.drive(5);
        System.out.println(crossMotorcycle.getFuel());
        familyCar.drive(6);
        System.out.println(familyCar.getFuel());
        sportCar.drive(3);
        System.out.println(sportCar.getFuel());
    }
}
