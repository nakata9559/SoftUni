package _23_PastExams._2023_08_August_15.handball;

import _23_PastExams._2023_08_August_15.handball.HandballPlayer;
import _23_PastExams._2023_08_August_15.handball.Team;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TeamTests {
    private static final HandballPlayer HANDBALL_PLAYER1 = new HandballPlayer("Gosho");
    private static final HandballPlayer HANDBALL_PLAYER2 = new HandballPlayer("Tosho");
    private static final HandballPlayer HANDBALL_PLAYER3 = new HandballPlayer("Mosho");
    private static final String NON_EXISTING_PLAYER_NAME = "Pesho";
    private static final String TEAM_NAME = "Kuci Kone";
    private static final int POSITION = 2;
    private Team team;

    @Before
    public void setUp() {
        this.team = new Team(TEAM_NAME, POSITION);
    }

    @Test(expected = NullPointerException.class)
    public void test_Create_Team_With_Null_Name() {
        new Team(null, POSITION);
    }

    @Test(expected = NullPointerException.class)
    public void test_Create_Team_With_Blank_Name() {
        new Team("  ", POSITION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Create_Team_With_Negative_Position() {
        new Team(TEAM_NAME, -1);
    }

    @Test
    public void test_Successfully_Created_Team() {
        Assert.assertEquals(TEAM_NAME, this.team.getName());
        Assert.assertEquals(POSITION, this.team.getPosition());
        Assert.assertEquals(0, this.team.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Add_Player_When_Team_Capacity_Full() {
        this.team.add(HANDBALL_PLAYER1);
        this.team.add(HANDBALL_PLAYER2);
        this.team.add(HANDBALL_PLAYER3);
    }

    @Test
    public void test_Successfully_Added_Player() {
        this.team.add(HANDBALL_PLAYER1);

        Assert.assertEquals(1, this.team.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Remove_Non_Existing_Player() {
        this.team.remove(NON_EXISTING_PLAYER_NAME);
    }

    @Test
    public void test_Successfully_Removed_Player() {
        this.team.add(HANDBALL_PLAYER1);
        this.team.remove(HANDBALL_PLAYER1.getName());

        Assert.assertEquals(0, this.team.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Player_For_Another_Team_Non_Existing_Player() {
        this.team.playerForAnotherTeam(NON_EXISTING_PLAYER_NAME);
    }

    @Test
    public void test_Player_For_Another_Team_Successfully_Executed() {
        this.team.add(HANDBALL_PLAYER1);

        HandballPlayer handballPlayer = this.team.playerForAnotherTeam(HANDBALL_PLAYER1.getName());

        Assert.assertFalse(handballPlayer.isActive());
    }

    @Test
    public void test_Get_Correct_Statistics() {
        this.team.add(HANDBALL_PLAYER1);

        String statistics = this.team.getStatistics();

        Assert.assertEquals(statistics,
                String.format("The player %s is in the team %s.",
                        HANDBALL_PLAYER1.getName(),
                        TEAM_NAME));
    }
}
