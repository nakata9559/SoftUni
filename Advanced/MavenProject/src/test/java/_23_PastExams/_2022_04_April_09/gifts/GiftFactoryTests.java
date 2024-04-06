package _23_PastExams._2022_04_April_09.gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

public class GiftFactoryTests {
    private static final Gift GIFT1 = new Gift("Glass", 100);
    private static final Gift GIFT2 = new Gift("Stone", 50);
    private static final Gift GIFT3 = new Gift("Chalk", 70);
    private GiftFactory giftFactory;

    @Before
    public void setUp() {
        this.giftFactory = new GiftFactory();
        this.giftFactory.createGift(GIFT1);
        this.giftFactory.createGift(GIFT2);
    }

    @Test
    public void test_Get_Correct_Count() {
        Assert.assertEquals(2, this.giftFactory.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Create_Gift_Already_Exists() {
        this.giftFactory.createGift(GIFT1);
    }

    @Test
    public void test_Successfully_Added_Gift() {
        String result = this.giftFactory.createGift(GIFT3);
        String expected = String.format("Successfully added gift %s with magic %.2f.", GIFT3.getType(), GIFT3.getMagic());

        Assert.assertEquals(expected, result);
    }

    @Test(expected = NullPointerException.class)
    public void test_Remove_Non_Existent_Gift() {
        this.giftFactory.removeGift(null);
    }

    @Test
    public void test_Successfully_Remove_Gift() {
        Assert.assertTrue(this.giftFactory.removeGift(GIFT1.getType()));
    }

    @Test
    public void test_Get_Present_With_Least_Magic_Correct_Present() {
        Assert.assertEquals(GIFT2, this.giftFactory.getPresentWithLeastMagic());
    }

    @Test
    public void test_Get_Present_Correct_Present() {
        Assert.assertEquals(GIFT1, this.giftFactory.getPresent(GIFT1.getType()));
    }

    @Test
    public void test_Get_Presents_Correct_Data() {
        Collection<Gift> gifts = this.giftFactory.getPresents();
        Assert.assertTrue(gifts.containsAll(List.of(GIFT1, GIFT2)));
    }
}
