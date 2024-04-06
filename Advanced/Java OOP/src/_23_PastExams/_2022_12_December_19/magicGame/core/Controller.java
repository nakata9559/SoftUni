package _23_PastExams._2022_12_December_19.magicGame.core;

public interface Controller {
    String addMagic(String type, String name, int bulletsCount);

    String addMagician(String type, String username, int health, int protection, String magicName);

    String startGame();

    String report();
}

