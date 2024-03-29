package _17_UnitTesting_Lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HP = 10;
    private static final int DUMMY_XP = 10;
    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HP, DUMMY_XP);
    }

    @Test
    public void losesHealthIfAttacked() {
        this.axe.attack(this.dummy);

        Assert.assertEquals(0, this.dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void cannotAttackDeadDummy() {
        this.axe.attack(this.dummy);

        this.dummy.takeAttack(this.axe.getAttackPoints());
    }

    @Test
    public void deadDummyCanGiveXP() {
        this.axe.attack(this.dummy);

        Assert.assertEquals(10, this.dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCannotGiveXP() {
        Dummy strongerDummy = new Dummy(20, DUMMY_XP);

        this.axe.attack(strongerDummy);

        strongerDummy.giveExperience();
    }
}
