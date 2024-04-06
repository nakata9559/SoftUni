package _23_PastExams._2023_08_August_15.handball.entities.gameplay;

import _23_PastExams._2023_08_August_15.handball.entities.equipment.Equipment;
import _23_PastExams._2023_08_August_15.handball.entities.team.Team;

import java.util.Collection;

public interface Gameplay {
    int allProtection();

    void addTeam(Team team);

    void removeTeam(Team team);

    void addEquipment(Equipment equipment);

    void teamsInGameplay();

    Collection<Team> getTeam();

    Collection<Equipment> getEquipments();

    String getName();


}
