package _06_Inheritance_Exc._03_PlayersAndMonsters;

public class Hero {
    private String username;
    private int level;

    public Hero(String name, int level) {
        this.username = name;
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return String.format("Type: %s Username: %s Level: %s",
                this.getClass().getName(), //.getSimpleName()
                this.getUsername(),
                this.getLevel());
    }
}
