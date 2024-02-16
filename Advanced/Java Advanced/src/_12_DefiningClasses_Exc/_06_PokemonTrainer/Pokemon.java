package _12_DefiningClasses_Exc._06_PokemonTrainer;

public class Pokemon {
    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public boolean stillAlive() {
        this.health -= 10;
        return this.health > 0;
    }

    public String getElement() {
        return element;
    }
}