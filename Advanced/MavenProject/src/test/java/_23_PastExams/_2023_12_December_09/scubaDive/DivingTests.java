package _23_PastExams._2023_12_December_09.scubaDive;


import _23_PastExams._2023_12_December_09.scubaDive.DeepWaterDiver;
import _23_PastExams._2023_12_December_09.scubaDive.Diving;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DivingTests {
    private static final DeepWaterDiver DEEP_WATER_DIVER1 = new DeepWaterDiver("Gosho", 30);
    private static final DeepWaterDiver DEEP_WATER_DIVER2 = new DeepWaterDiver("Pesho", 40);
    private static final DeepWaterDiver DEEP_WATER_DIVER3 = new DeepWaterDiver("Stamat", 50);
    private static final String DIVING_NAME = "Giopca";
    private static final int DIVING_CAPACITY = 2;
    private Diving diving;

    @Before
    public void setUp() {
        this.diving = new Diving(DIVING_NAME, DIVING_CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Set_Invalid_Capacity() {
        new Diving(DIVING_NAME, -1);
    }

    @Test(expected = NullPointerException.class)
    public void test_Set_Null_Name() {
        new Diving(null, DIVING_CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void test_Set_Blank_Name() {
        new Diving("   ", DIVING_CAPACITY);
    }

    @Test
    public void test_Correct_Diving_Class_Initialising() {
        Assert.assertEquals(this.diving.getName(), DIVING_NAME);
        Assert.assertEquals(this.diving.getCapacity(), DIVING_CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Add_Diver_When_Capacity_Full() {
        this.diving.addDeepWaterDiver(DEEP_WATER_DIVER1);
        this.diving.addDeepWaterDiver(DEEP_WATER_DIVER2);
        this.diving.addDeepWaterDiver(DEEP_WATER_DIVER3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Add_Existing_Diver() {
        this.diving.addDeepWaterDiver(DEEP_WATER_DIVER1);
        this.diving.addDeepWaterDiver(DEEP_WATER_DIVER1);
    }

    @Test
    public void test_Add_Correct_Diver() {
        this.diving.addDeepWaterDiver(DEEP_WATER_DIVER1);
        this.diving.addDeepWaterDiver(DEEP_WATER_DIVER2);

        Assert.assertEquals(2, this.diving.getCount());
    }

    @Test
    public void test_Remove_Correct_Diver() {
        this.diving.addDeepWaterDiver(DEEP_WATER_DIVER1);

        Assert.assertTrue(this.diving.removeDeepWaterDiver(DEEP_WATER_DIVER1.getName()));
    }
}
