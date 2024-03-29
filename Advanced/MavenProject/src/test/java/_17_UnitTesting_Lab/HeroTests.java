package _17_UnitTesting_Lab;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTests {
    private static final String HERO_NAME = "Gosho";
    private static final int TARGET_XP = 10;
    private static final String TARGET_LOOT = "Wooden Leg";

//    @Test
//    public void attackGainsExperienceIfTargetIsDead() {
//        Target fakeTarget = new Target() {
//            public int getHealth() {
//                return 0;
//            }
//            public void takeAttack(int attackPoints) {
//
//            }
//            public int giveExperience() {
//                return TARGET_XP;
//            }
//            public boolean isDead() {
//                return true;
//            }
//        };
//
//        Weapon fakeWeapon = new Weapon() {
//            public int getAttackPoints() {
//                return 10;
//            }
//            public int getDurabilityPoints() {
//                return 0;
//            }
//            public void attack(Target target) {
//
//            }
//        };
//
//        Hero hero = new Hero(HERO_NAME, fakeWeapon);
//        hero.attack(fakeTarget);
//        Assert.assertEquals("Wrong experience", TARGET_XP, hero.getExperience());
//    }

    @Test
    public void attackGainsExperienceIfTargetIsDead() {
        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);

        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_XP);

        Hero hero = new Hero(HERO_NAME, weaponMock);

        hero.attack(targetMock);

        Assert.assertEquals("Wrong experience", TARGET_XP, hero.getExperience());
    }

    @Test
    public void getLootUponKillingATarget() {
        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);

        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.dropLoot()).thenReturn(TARGET_LOOT);

        Hero hero = new Hero(HERO_NAME, weaponMock);

        hero.attack(targetMock);

        Assert.assertEquals("Wrong loot", TARGET_LOOT, hero.getInventory().getFirst());
    }
}
