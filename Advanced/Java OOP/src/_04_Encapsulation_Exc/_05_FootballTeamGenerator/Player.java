package _04_Encapsulation_Exc._05_FootballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public String getName() {
        return name;
    }

    public double overallSkillLevel() {
        return (this.endurance +
                this.sprint +
                this.dribble +
                this.passing +
                this.shooting) / 5.0;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        checkStat("Endurance", endurance);
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        checkStat("Sprint", sprint);
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        checkStat("Dribble", dribble);
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        checkStat("Passing", passing);
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        checkStat("Shooting", shooting);
        this.shooting = shooting;
    }

    private void checkStat(String statName, int statValue) {
        if (statValue < 0 || statValue > 100) {
            throw new IllegalArgumentException(statName + " should be between 0 and 100.");
        }
    }
}
