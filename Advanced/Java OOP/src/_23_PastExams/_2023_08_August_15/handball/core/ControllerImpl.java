package _23_PastExams._2023_08_August_15.handball.core;

import _23_PastExams._2023_08_August_15.handball.entities.equipment.Equipment;
import _23_PastExams._2023_08_August_15.handball.entities.equipment.ElbowPad;
import _23_PastExams._2023_08_August_15.handball.entities.equipment.Kneepad;
import _23_PastExams._2023_08_August_15.handball.entities.gameplay.Gameplay;
import _23_PastExams._2023_08_August_15.handball.entities.gameplay.Indoor;
import _23_PastExams._2023_08_August_15.handball.entities.gameplay.Outdoor;
import _23_PastExams._2023_08_August_15.handball.entities.team.Bulgaria;
import _23_PastExams._2023_08_August_15.handball.entities.team.Germany;
import _23_PastExams._2023_08_August_15.handball.entities.team.Team;
import _23_PastExams._2023_08_August_15.handball.repositories.EquipmentRepository;
import _23_PastExams._2023_08_August_15.handball.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;

import static _23_PastExams._2023_08_August_15.handball.common.ConstantMessages.*;
import static _23_PastExams._2023_08_August_15.handball.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{
    private Repository equipment;
    private Collection<Gameplay> gameplays;

    public ControllerImpl() {
        this.equipment = new EquipmentRepository();
        this.gameplays = new ArrayList<>();
    }

    @Override
    public String addGameplay(String gameplayType, String gameplayName) {
        switch (gameplayType) {
            case "Outdoor":
                this.gameplays.add(new Outdoor(gameplayName));
                break;

            case "Indoor":
                this.gameplays.add(new Indoor(gameplayName));
                break;

            default:
                throw new NullPointerException(INVALID_GAMEPLAY_TYPE);
        }

        return String.format(SUCCESSFULLY_ADDED_GAMEPLAY_TYPE, gameplayType);
    }

    @Override
    public String addEquipment(String equipmentType) {
        switch (equipmentType) {
            case "Kneepad":
                this.equipment.add(new Kneepad());
                break;

            case "ElbowPad":
                this.equipment.add(new ElbowPad());
                break;

            default:
                throw new IllegalArgumentException(INVALID_EQUIPMENT_TYPE);
        }

        return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_TYPE, equipmentType);
    }

    @Override
    public String equipmentRequirement(String gameplayName, String equipmentType) {
        Equipment equipment = this.equipment.findByType(equipmentType);

        if (null == equipment) {
            throw new IllegalArgumentException(String.format(NO_EQUIPMENT_FOUND, equipmentType));
        }

        getGameplayByName(gameplayName).addEquipment(equipment);

        this.equipment.remove(equipment);

        return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_IN_GAMEPLAY, equipmentType, gameplayName);
    }

    @Override
    public String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage) {
        Team team;

        switch (teamType) {
            case "Bulgaria":
                team = new Bulgaria(teamName, country, advantage);
                break;

            case "Germany":
                team = new Germany(teamName, country, advantage);
                break;

            default:
                throw new IllegalArgumentException(INVALID_TEAM_TYPE);
        }

        getGameplayByName(gameplayName).addTeam(team);

        return String.format(SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, teamType, gameplayName);
    }

    @Override
    public String playInGameplay(String gameplayName) {
        Gameplay gameplay = getGameplayByName(gameplayName);

        gameplay.teamsInGameplay();

        return String.format(TEAMS_PLAYED, gameplay.getTeam().size());
    }

    @Override
    public String percentAdvantage(String gameplayName) {
        return String.format(ADVANTAGE_GAMEPLAY,
                gameplayName,
                getGameplayByName(gameplayName)
                        .getTeam()
                        .stream()
                        .mapToInt(Team::getAdvantage)
                        .sum());
    }

    @Override
    public String getStatistics() {
        return String.join(System.lineSeparator(),
                this.gameplays.stream()
                        .map(Gameplay::toString)
                        .toArray(String[]::new));
    }

    private Gameplay getGameplayByName(String gameplayName) {
        return this.gameplays.stream()
                .filter(gameplay -> gameplay.getName().equals(gameplayName))
                .findFirst()
                .orElse(null);
    }
}
