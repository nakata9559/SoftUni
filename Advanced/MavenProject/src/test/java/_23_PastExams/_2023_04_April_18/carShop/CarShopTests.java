package _23_PastExams._2023_04_April_18.carShop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CarShopTests {
    private static final Car CAR1 = new Car("Lada", 250, 19999);
    private static final Car CAR2 = new Car("Moskvich", 350, 15999);
    private static final Car CAR3 = new Car("VAZ", 150, 29999);
    private CarShop carShop;

    @Before
    public void setUp() {
        this.carShop = new CarShop();
        this.carShop.add(CAR1);
        this.carShop.add(CAR2);
        this.carShop.add(CAR3);
    }

    @Test
    public void test_Get_Correct_Count() {
        Assert.assertEquals(3, this.carShop.getCount());
    }

    @Test
    public void test_Find_Cars_With_Max_Horsepower() {
        List<Car> cars = this.carShop.findAllCarsWithMaxHorsePower(200);

        Assert.assertEquals(2, cars.size());
    }

    @Test(expected = NullPointerException.class)
    public void test_Add_Null_Car() {
        this.carShop.add(null);
    }

    @Test
    public void test_Remove_Correct_Car() {
        this.carShop.remove(CAR1);

        Assert.assertEquals(2, this.carShop.getCount());
    }

    @Test
    public void test_Get_Most_Luxury_Car() {
        Car car = this.carShop.getTheMostLuxuryCar();

        Assert.assertEquals(car, CAR3);
    }

    @Test
    public void test_Find_All_Cars_By_Model() {
        Car car = this.carShop.findAllCarByModel(CAR1.getModel())
                .stream()
                .findFirst()
                .orElse(null);

        Assert.assertEquals(car, CAR1);
    }

}

