package _23_PastExams._2022_12_December_19.magicGame.models.magicians;

import _23_PastExams._2022_12_December_19.magicGame.models.magics.Magic;

public interface Magician {
    String getUsername();

    int getHealth();

    int getProtection();

    Magic getMagic();

    boolean isAlive();

    void takeDamage(int points);
}
