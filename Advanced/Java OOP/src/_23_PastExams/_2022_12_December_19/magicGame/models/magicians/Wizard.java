package _23_PastExams._2022_12_December_19.magicGame.models.magicians;

import _23_PastExams._2022_12_December_19.magicGame.models.magics.Magic;

public class Wizard extends MagicianImpl{

    public Wizard(String username, int health, int protection, Magic magic) {
        super(username, health, protection, magic);
    }
}
