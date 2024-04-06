package _23_PastExams._2021_12_December_20.garage;

import _23_PastExams._2021_12_December_20.garage.Car;
import _23_PastExams._2021_12_December_20.garage.Garage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GarageTests {
    private static final Car CAR1 = new Car("Lada", 120, 7999);
    private static final Car CAR2 = new Car("Moskvich", 110, 6999);
    private static final Car CAR3 = new Car("Lada", 100, 5999);
    private Garage garage;

    @Before
    public void setUp() {
        this.garage = new Garage();
        this.garage.addCar(CAR1);
        this.garage.addCar(CAR2);
        this.garage.addCar(CAR3);
    }

    @Test
    public void test_Get_Cars() {
        List<Car> expected = List.of(CAR1, CAR2, CAR3);
        List<Car> result = this.garage.getCars();

        Assert.assertEquals(expected, result);
    }

    @Test
    public void test_Get_Correct_Count() {
        Assert.assertEquals(3, this.garage.getCount());
    }

    @Test
    public void test_Find_All_Cars_With_Max_Speed_Above_Correct_Cars() {
        List<Car> expected = List.of(CAR1, CAR2);
        List<Car> result = this.garage.findAllCarsWithMaxSpeedAbove(105);

        Assert.assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Add_Car_Null() {
        this.garage.addCar(null);
    }

    @Test
    public void test_Get_The_Most_Expensive_Car_Correct_Car() {
        Assert.assertEquals(CAR1, this.garage.getTheMostExpensiveCar());
    }

    @Test
    public void test_Find_All_Cars_By_Brand_Correct_Cars() {
        List<Car> expected = List.of(CAR1, CAR3);
        List<Car> result = this.garage.findAllCarsByBrand("Lada");

        Assert.assertEquals(expected, result);
    }
}