package _23_PastExams._2022_08_August_14.football.entities.player;

import static _23_PastExams._2022_08_August_14.football.common.ExceptionMessages.*;

public abstract class BasePlayer implements Player{
    private String name;
    private String nationality;
    private double kg;
    private int strength;

    public BasePlayer(String name, String nationality, double kg, int strength) {
        this.setName(name);
        this.setNationality(nationality);
        this.kg = kg;
        this.setStrength(strength);
    }

    @Override
    public void setName(String name) {
        if (null == name || name.trim().isEmpty()) {
            throw new NullPointerException(PLAYER_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public void stimulation() {
        if (this instanceof Men) {
            this.setStrength(this.strength + 145);
        } else if (this instanceof Women){
            this.setStrength(this.strength + 115);
        }
    }

    @Override
    public double getKg() {
        return this.kg;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    protected void setStrength(int strength) {
        if (strength <= 0) {
            throw new IllegalArgumentException(PLAYER_STRENGTH_BELOW_OR_EQUAL_ZERO);
        }

        this.strength = strength;
    }

    private void setNationality(String nationality) {
        if (null == nationality || nationality.trim().isEmpty()) {
            throw new NullPointerException(PLAYER_NATIONALITY_NULL_OR_EMPTY);
        }

        this.nationality = nationality;
    }
}
