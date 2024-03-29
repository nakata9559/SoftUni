package _17_UnitTesting_Lab;

public class Dummy implements Target{

    private static String LOOT = "Wooden Leg";
    private int health;
    private int experience;
    private String loot;

    public Dummy(int health, int experience) {
        this.health = health;
        this.experience = experience;
        this.loot = LOOT;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("Dummy is dead.");
        }

        this.health -= attackPoints;
    }

    @Override
    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.experience;
    }

    @Override
    public boolean isDead() {
        return this.health <= 0;
    }

    @Override
    public String dropLoot() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.loot;
    }
}
