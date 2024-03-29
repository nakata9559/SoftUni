package _23_PastExams._2023_12_December_19.stuntClimb;


import _23_PastExams._2023_12_December_19.stuntClimb.Climbing;
import _23_PastExams._2023_12_December_19.stuntClimb.RockClimber;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClimbingTests {
    private static final RockClimber CLIMBER1 = new RockClimber("Gosho", 10);
    private static final RockClimber CLIMBER2 = new RockClimber("Pesho", 20);
    private static final RockClimber CLIMBER3 = new RockClimber("Stilian", 30);
    private static final String CLIMBING_NAME = "Musala";
    private static final int CLIMBING_CAPACITY = 2;
    private Climbing climbing;

    @Before
    public void setUp() {
        this.climbing = new Climbing(CLIMBING_NAME, CLIMBING_CAPACITY);
    }

    @Test
    public void test_Initialising_Climber() {
        Assert.assertEquals(CLIMBER1.getName(), "Gosho");
        Assert.assertEquals(CLIMBER1.getStrength(), 10, 0.0);
    }

    @Test(expected = NullPointerException.class)
    public void test_Climbing_Set_Name_Null() {
        new Climbing(null, CLIMBING_CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void test_Climbing_Set_Name_Blank() {
        new Climbing("   ", CLIMBING_CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Climbing_Set_Capacity_Negative() {
        new Climbing(CLIMBING_NAME, -1);
    }

    @Test
    public void test_Correctly_Initialised_Climbing_Class() {
        Assert.assertEquals(CLIMBING_NAME, this.climbing.getName());
        Assert.assertEquals(CLIMBING_CAPACITY, this.climbing.getCapacity());
        Assert.assertEquals(0, this.climbing.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Add_Climber_When_Capacity_Full() {
        this.climbing.addRockClimber(CLIMBER1);
        this.climbing.addRockClimber(CLIMBER2);
        this.climbing.addRockClimber(CLIMBER3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Add_Climber_Already_Exists() {
        this.climbing.addRockClimber(CLIMBER1);
        this.climbing.addRockClimber(CLIMBER1);
    }

    @Test
    public void test_Correctly_Add_Climber() {
        this.climbing.addRockClimber(CLIMBER1);
        this.climbing.addRockClimber(CLIMBER2);

        Assert.assertEquals(2, this.climbing.getCount());
    }

    @Test
    public void test_Remove_Non_Existent_Climber() {
        Assert.assertFalse(this.climbing.removeRockClimber(CLIMBER1.getName()));
    }

    @Test
    public void test_Remove_Correct_Climber() {
        this.climbing.addRockClimber(CLIMBER1);
        this.climbing.addRockClimber(CLIMBER2);

        this.climbing.removeRockClimber(CLIMBER1.getName());

        Assert.assertEquals(1, this.climbing.getCount());
    }
}
