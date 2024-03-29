package _23_PastExams._2022_08_August_22.archeologicalExcavations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExcavationTests {
    private static final String ARCHAEOLOGIST_NAME = "Gosho";
    private static final Archaeologist ARCHAEOLOGIST = new Archaeologist(ARCHAEOLOGIST_NAME, 100);
    private static final int EXCAVATION_CAPACITY = 3;
    private static final String EXCAVATION_NAME = "Kriva Mogila";
    private Excavation excavation;

    @Before
    public void setUp() {
        this.excavation = new Excavation(EXCAVATION_NAME, EXCAVATION_CAPACITY);
    }

//      -- Излишно! --
//    @Test
//    public void test_Class_Excavation_Initiated_Correctly() {
//        Assert.assertEquals(EXCAVATION_NAME, this.excavation.getName());
//        Assert.assertEquals(EXCAVATION_CAPACITY, this.excavation.getCapacity());
//        Assert.assertEquals(0, this.excavation.getCount());
//    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Invalid_Capacity() {
        new Excavation(EXCAVATION_NAME, -10);
    }

    @Test(expected = NullPointerException.class)
    public void test_Invalid_Excavation_Name() {
        new Excavation("   ", EXCAVATION_CAPACITY);
        new Excavation(null, EXCAVATION_CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Adding_Archaeologist_Exceeds_Capacity() {
        for (int i = 1; i <= EXCAVATION_CAPACITY + 1; i++) {
            Archaeologist archaeologist = new Archaeologist(ARCHAEOLOGIST_NAME + " " + i, 100);
            this.excavation.addArchaeologist(archaeologist);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Adding_Existing_Archaeologist() {
        this.excavation.addArchaeologist(ARCHAEOLOGIST);
        this.excavation.addArchaeologist(ARCHAEOLOGIST);
    }

    @Test
    public void test_Successfully_Removed_Archaeologist() {
        this.excavation.addArchaeologist(ARCHAEOLOGIST);

        Assert.assertTrue(this.excavation.removeArchaeologist(ARCHAEOLOGIST_NAME));
    }

//    -- Излишно! --
//    @Test
//    public void test_Remove_Non_Existent_Archaeologist() {
//        this.excavation.addArchaeologist(ARCHAEOLOGIST);
//
//        Assert.assertFalse(this.excavation.removeArchaeologist("Ne Gosho"));
//    }
}
