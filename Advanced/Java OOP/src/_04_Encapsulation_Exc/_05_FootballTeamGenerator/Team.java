package _04_Encapsulation_Exc._05_FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String playerName) {
        if (players.stream().noneMatch(e -> e.getName().equals(playerName))) {
            throw new IllegalArgumentException("_04_Encapsulation_Exc._05_FootballTeamGenerator.Player " + playerName + " is not in " + this.name + " team.");
        }
        players.removeIf(e -> e.getName().equals(playerName));
    }

    public double getRating() {
        return this.players.stream()
                .mapToDouble(Player::overallSkillLevel)
                .average()
                .orElse(0.0);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }
}
