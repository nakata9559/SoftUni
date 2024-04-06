package _23_PastExams._2022_12_December_19.magicGame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

public class MagicianTests {
    private static final Magic MAGIC1 = new Magic("Expeliarmos", 5);
    private static final Magic MAGIC2 = new Magic("Crucio", 20);
    private static final Magic MAGIC3 = new Magic("Avada Kedavra", 666);
    private static final String USERNAME = "Harry";
    private static final int HEALTH = 1000;
    private Magician magician;

    @Before
    public void setUp() {
        this.magician = new Magician(USERNAME, HEALTH);
        this.magician.addMagic(MAGIC1);
        this.magician.addMagic(MAGIC2);
        this.magician.addMagic(MAGIC3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Create_Magician_With_Negative_Health() {
        new Magician(USERNAME, -1);
    }

    @Test(expected = NullPointerException.class)
    public void test_Create_Magician_With_Invalid_Name() {
        new Magician(null, HEALTH);
        new Magician("   ", HEALTH);
    }

    @Test(expected = IllegalStateException.class)
    public void test_Take_Damage_When_Magician_Is_Dead() {
        magician.takeDamage(500);
        magician.takeDamage(501);
        magician.takeDamage(1001);
    }

    @Test(expected = NullPointerException.class)
    public void test_Add_Null_Magic() {
        magician.addMagic(null);
    }

    @Test
    public void test_Remove_Correct_Magic() {
        Assert.assertTrue(this.magician.removeMagic(MAGIC1));
    }

    @Test
    public void test_Get_Magic_Returns_Correct_Magic() {
        Magic magic = this.magician.getMagic(MAGIC3.getName());

        Assert.assertEquals(magic.getBullets(), MAGIC3.getBullets());
    }

    @Test
    public void test_Get_Magics() {
        Collection<Magic> magics1 = List.of(MAGIC1, MAGIC2, MAGIC3);
        Collection<Magic> magics2 = this.magician.getMagics();

        Assert.assertEquals(magics1, magics2);
    }

    @Test
    public void test_Get_Health() {
        int health = this.magician.getHealth();

        Assert.assertEquals(health, HEALTH);
    }

    @Test
    public void test_Get_Username() {
        String username = this.magician.getUsername();

        Assert.assertEquals(username, USERNAME);
    }
}
