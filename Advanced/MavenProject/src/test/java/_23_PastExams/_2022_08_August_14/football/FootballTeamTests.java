package _23_PastExams._2022_08_August_14.football;

import _23_PastExams._2022_08_August_14.football.FootballTeam;
import _23_PastExams._2022_08_August_14.football.Footballer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FootballTeamTests {
    private static final Footballer FOOTBALLER1 = new Footballer("Messi");
    private static final Footballer FOOTBALLER2 = new Footballer("Penaldo");
    private static final String TEAM_NAME = "Kuci Kone";
    private static final int VACANT_POSITIONS = 1;
    private FootballTeam footballTeam;

    @Before
    public void setUp() {
        this.footballTeam = new FootballTeam(TEAM_NAME, VACANT_POSITIONS);
        this.footballTeam.addFootballer(FOOTBALLER1);
    }

    @Test(expected = NullPointerException.class)
    public void test_Set_Invalid_Name() {
        new FootballTeam("  ", VACANT_POSITIONS);
        new FootballTeam(null, VACANT_POSITIONS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Set_Team_Negative_Vacant_Positions() {
        new FootballTeam(TEAM_NAME, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Add_Footballer_When_Team_Is_Full() {
        this.footballTeam.addFootballer(FOOTBALLER2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Remove_Non_Existent_Player() {
        this.footballTeam.removeFootballer(FOOTBALLER2.getName());
    }

    @Test
    public void test_Remove_Correct_Player() {
        this.footballTeam.removeFootballer(FOOTBALLER1.getName());

        Assert.assertEquals(0, this.footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Footballer_For_Sale_Non_Existent_Player() {
        this.footballTeam.footballerForSale(FOOTBALLER2.getName());
    }

    @Test
    public void test_Footballer_For_Sale_Correct_Player() {
        Footballer footballer = this.footballTeam.footballerForSale(FOOTBALLER1.getName());

        Assert.assertFalse(footballer.isActive());
    }

    @Test
    public void test_Correct_Get_Statistics() {
        String expected = String.format("The footballer %s is in the team %s.", FOOTBALLER1.getName(), TEAM_NAME);
        String result = this.footballTeam.getStatistics();

        Assert.assertEquals(expected, result);

    }

}
