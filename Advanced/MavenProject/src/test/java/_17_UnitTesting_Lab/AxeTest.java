package _17_UnitTesting_Lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HP = 10;
    private static final int DUMMY_XP = 10;
    private static final int EXPECTED_DURABILITY = AXE_DURABILITY - 1;
    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HP, DUMMY_XP);
    }


    @Test
    public void weaponAttackLosesDurability() {
        this.axe.attack(this.dummy);

        Assert.assertEquals(EXPECTED_DURABILITY, this.axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void brokenWeaponCannotAttack() {
        Axe fragileAxe = new Axe(AXE_ATTACK, 1);

        fragileAxe.attack(this.dummy);
        fragileAxe.attack(this.dummy);
    }
}
