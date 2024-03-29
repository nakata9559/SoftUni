package _17_UnitTesting_Lab;

public interface Target {
    int getHealth();

    void takeAttack(int attackPoints);

    int giveExperience();

    boolean isDead();

    String dropLoot();
}
