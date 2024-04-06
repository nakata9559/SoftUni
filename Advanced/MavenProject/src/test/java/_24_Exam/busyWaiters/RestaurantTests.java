package _24_Exam.busyWaiters;


import _24_Exam.busyWaiters.FullTimeWaiter;
import _24_Exam.busyWaiters.Restaurant;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

public class RestaurantTests {
    private static final FullTimeWaiter WAITER1 = new FullTimeWaiter("Gosho", 8);
    private static final FullTimeWaiter WAITER2 = new FullTimeWaiter("Pesho", 6);
    private static final FullTimeWaiter WAITER3 = new FullTimeWaiter("Stamat", 4);
    private static final String RESTAURANT_NAME = "19 Vek";
    private static final int RESTAURANT_CAPACITY = 2;
    private Restaurant restaurant;

    @Before
    public void setUp() {
        this.restaurant = new Restaurant(RESTAURANT_NAME, RESTAURANT_CAPACITY);
        this.restaurant.addFullTimeWaiter(WAITER1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Create_Restaurant_With_Invalid_Capacity() {
        new Restaurant(RESTAURANT_NAME, -1);
    }

    @Test(expected = NullPointerException.class)
    public void test_Create_Restaurant_With_Invalid_Name() {
        new Restaurant(null, RESTAURANT_CAPACITY);
        new Restaurant("  ", RESTAURANT_CAPACITY);
    }

    @Test
    public void test_Correctly_Created_New_Restaurant() {
        Assert.assertEquals(RESTAURANT_NAME, this.restaurant.getName());
        Assert.assertEquals(RESTAURANT_CAPACITY, this.restaurant.getCapacity());

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Add_Waiter_When_Capacity_Full() {
        this.restaurant.addFullTimeWaiter(WAITER2);
        this.restaurant.addFullTimeWaiter(WAITER3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Add_Waiter_Already_Exists() {
        this.restaurant.addFullTimeWaiter(WAITER1);
    }

    @Test
    public void test_Correctly_Addded_New_Waiter() {
        this.restaurant.addFullTimeWaiter(WAITER2);

        Collection<FullTimeWaiter> expected = List.of(WAITER1, WAITER2);
        Collection<FullTimeWaiter> result = this.restaurant.getWaiters();

        Assert.assertEquals(2, this.restaurant.getCount());
        Assert.assertEquals(expected, result);
    }

    @Test
    public void test_Remove_Non_Existent_Waiter() {
        Assert.assertFalse(this.restaurant.removeFullTimeWaiter(WAITER2.getName()));
    }

    @Test
    public void test_Correctly_Remove_Waiter() {
        Assert.assertTrue(this.restaurant.removeFullTimeWaiter(WAITER1.getName()));
    }

}
