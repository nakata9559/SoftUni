package _23_PastExams._2023_04_April_08.robots;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServiceTests {
    private static final String SERVICE_NAME = "Service";
    private static final int CAPACITY = 2;
    private static final Robot ROBOT = new Robot("Gosho");
    private Service service;

    @Before
    public void setUp() {
        this.service = new Service(SERVICE_NAME, CAPACITY);
    }

//    @Test
//    public void test_Constructor() {
//        this.service = new Service(SERVICE_NAME, CAPACITY);
//        Assert.assertEquals(SERVICE_NAME, this.service.getName());
//        Assert.assertEquals(CAPACITY, this.service.getCapacity());
//        Assert.assertEquals(0, this.service.getCount());
//    }

//    @Test
//    public void test_Robot_Count() {
//        this.service.add(ROBOT);
//        Assert.assertEquals(1, this.service.getCount());
//    }
//
//    @Test
//    public void test_Get_Service_Name() {
//        Assert.assertEquals("Service", this.service.getName());
//    }
//
//    @Test
//    public void test_Get_Service_Capacity() {
//        Assert.assertEquals(2, this.service.getCapacity());
//    }

    @Test (expected = NullPointerException.class)
    public void test_Set_Null_Name() {
        new Service(null, CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void test_Set_Blank_Name() {
        new Service("   ", CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Set_Negative_Capacity() {
        new Service(SERVICE_NAME, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Add_Robot_While_Full_Capacity() {
        this.service.add(ROBOT);
        this.service.add(ROBOT);
        this.service.add(ROBOT);
    }

//    @Test
//    public void test_Remove_Correct_Robot() {
//        this.service.add(ROBOT);
//        this.service.remove(ROBOT.getName());
//        Assert.assertEquals(0, this.service.getCount());
//    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Remove_Null_Robot() {
        this.service.add(ROBOT);
        this.service.remove("Pesho");
    }

    @Test
    public void test_For_Sale_Correct_Robot() {
        this.service.add(ROBOT);
        Assert.assertFalse(this.service.forSale(ROBOT.getName()).isReadyForSale());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_For_Sale_Null_Robot() {
        this.service.add(ROBOT);
        this.service.forSale("Pesho");
    }

    @Test
    public void test_Report_Correct_Data() {
        this.service.add(ROBOT);

        Assert.assertEquals("The robot Gosho is in the service Service!", this.service.report());
    }
}
