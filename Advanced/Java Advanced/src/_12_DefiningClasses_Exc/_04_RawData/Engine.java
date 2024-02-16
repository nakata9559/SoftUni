package _12_DefiningClasses_Exc._04_RawData;

public class Engine {
    private int speed;
    private int power;

    public Engine(int speed, int power) {
        this.speed = speed;
        this.power = power;
    }

    public boolean checkPower() {
        return power > 250;
    }

}
