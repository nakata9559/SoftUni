package _05_Inheritance_Lab._03_RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {

    public Object getRandomElement() {
        Random random = new Random();
        int randomIndex = random.nextInt(super.size());
        return super.remove(randomIndex);
    }
}
