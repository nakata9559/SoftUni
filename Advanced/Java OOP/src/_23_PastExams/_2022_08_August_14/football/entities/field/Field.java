package _23_PastExams._2022_08_August_14.football.entities.field;

import _23_PastExams._2022_08_August_14.football.entities.player.Player;
import _23_PastExams._2022_08_August_14.football.entities.supplement.Supplement;

import java.util.Collection;

public interface Field {
    int sumEnergy();

    void addPlayer(Player player);

    void removePlayer(Player player);

    void addSupplement(Supplement supplement);

    void drag() throws NoSuchFieldException, IllegalAccessException;

    String getInfo();

    Collection<Player> getPlayers();

    Collection<Supplement> getSupplements();

    String getName();
}
