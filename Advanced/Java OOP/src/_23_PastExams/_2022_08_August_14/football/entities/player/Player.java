package _23_PastExams._2022_08_August_14.football.entities.player;

public interface Player {
    void setName(String name);

    void stimulation() throws NoSuchFieldException, IllegalAccessException;

    double getKg();

    String getName();

    int getStrength();


}
