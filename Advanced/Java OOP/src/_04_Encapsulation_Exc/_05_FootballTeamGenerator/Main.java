package _04_Encapsulation_Exc._05_FootballTeamGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Team> teams = new HashMap<>();

        String[] tokens = scanner.nextLine().trim().split(";");

        while (!"END".equals(tokens[0])) {
            executeCommand(tokens, teams);
            tokens = scanner.nextLine().trim().split(";");
        }
    }

    private static void executeCommand(String[] tokens, Map<String, Team> teams) {
        String command = tokens[0];
        String name = tokens[1];

        try {
            switch (command) {
                case "_04_Encapsulation_Exc._05_FootballTeamGenerator.Team":
                    Team team = new Team(name);
                    teams.put(name, team);
                    break;

                case "Add":
                    checkIfExists(name, teams);
                    Player playerToAdd = new Player(tokens[2],
                            Integer.parseInt(tokens[3]),
                            Integer.parseInt(tokens[4]),
                            Integer.parseInt(tokens[5]),
                            Integer.parseInt(tokens[6]),
                            Integer.parseInt(tokens[7]));
                    teams.get(name).addPlayer(playerToAdd);
                    break;

                case "Remove":
                    checkIfExists(name, teams);
                    String playerToRemove = tokens[2];
                    teams.get(name).removePlayer(playerToRemove);
                    break;

                case "Rating":
                    checkIfExists(name, teams);
                    System.out.printf("%s - %.0f%n",
                            teams.get(name).getName(),
                            teams.get(name).getRating());
                    break;
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void checkIfExists(String teamName, Map<String, Team> teams) {
        if (!teams.containsKey(teamName)) {
            throw new IllegalArgumentException("_04_Encapsulation_Exc._05_FootballTeamGenerator.Team " + teamName + " does not exist.");
        }
    }
}
