package _23_PastExams._2023_08_August_15.handball.entities.gameplay;

import _23_PastExams._2023_08_August_15.handball.entities.equipment.Equipment;
import _23_PastExams._2023_08_August_15.handball.entities.team.Team;

import java.util.ArrayList;
import java.util.Collection;

import static _23_PastExams._2023_08_August_15.handball.common.ExceptionMessages.GAMEPLAY_NAME_NULL_OR_EMPTY;

public abstract class BaseGameplay implements Gameplay{
    private String name;
    private int capacity;
    private Collection<Equipment> equipments;
    private Collection<Team> teams;

    public BaseGameplay(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.equipments = new ArrayList<>();
        this.teams = new ArrayList<>();
    }

    @Override
    public int allProtection() {
        return this.equipments.stream()
                .mapToInt(Equipment::getProtection)
                .sum();
    }

    @Override
    public void addTeam(Team team) {
        if (this.capacity > this.teams.size()) {
            this.teams.add(team);
        }
    }

    @Override
    public void removeTeam(Team team) {
        this.teams.remove(team);
    }

    @Override
    public void addEquipment(Equipment equipment) {
        this.equipments.add(equipment);
    }

    @Override
    public void teamsInGameplay() {
        this.teams.forEach(Team::play);
    }

    @Override
    public Collection<Team> getTeam() {
        return this.teams;
    }

    @Override
    public Collection<Equipment> getEquipments() {
        return this.equipments;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s %s", this.name, this.getClass().getSimpleName()));
        sb.append(System.lineSeparator());

        sb.append("Team: ");
        String teams = this.teams.isEmpty() ?
                "none" :
                String.join(" ", this.teams.stream()
                        .map(Team::getName)
                        .toArray(String[]::new));
        sb.append(teams);
        sb.append(System.lineSeparator());

        sb.append(String.format("Equipment: %d, Protection: %d",
                this.equipments.size(),
                this.allProtection()));

        return sb.toString();
    }

    private void setName(String name) {
        if (null == name || name.trim().isEmpty()) {
            throw new NullPointerException(GAMEPLAY_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }
}
