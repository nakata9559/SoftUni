package _23_PastExams._2022_12_December_10.toyStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

public class ToyStoryTest {
    private static final Toy TOY1 = new Toy("Chipolino", "CH112");
    private static final Toy TOY2 = new Toy("Moni", "MO213");
    private ToyStore toyStore;

    @Before
    public void setUp() {
        this.toyStore = new ToyStore();
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Add_Toy_To_Non_Existent_Shelf() throws OperationNotSupportedException {
        this.toyStore.addToy("H", TOY1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Add_Toy_To_Full_Shelf() throws OperationNotSupportedException {
        this.toyStore.addToy("A", TOY1);
        this.toyStore.addToy("A", TOY2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Add_Toy_Already_Exists() throws OperationNotSupportedException {
        this.toyStore.addToy("A", TOY1);
        this.toyStore.addToy("B", TOY1);
    }

    @Test
    public void test_Successfully_Added_Toy() throws OperationNotSupportedException {
        String result = this.toyStore.addToy("A", TOY1);

        Assert.assertEquals(result, String.format("Toy:%s placed successfully!", TOY1.getToyId()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Remove_Toy_From_Non_Existent_Shelf() {
        this.toyStore.removeToy("H", TOY1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Remove_Non_Existent_Toy_From_Shelf() {
        this.toyStore.removeToy("A", TOY1);
    }

    @Test
    public void test_Successfully_Removed_Toy_From_Shelf() throws OperationNotSupportedException {
        this.toyStore.addToy("A", TOY1);
        String result = this.toyStore.removeToy("A", TOY1);

        Assert.assertEquals(result, String.format("Remove toy:%s successfully!", TOY1.getToyId()));
    }

    @Test
    public void test_Get_Correct_Toy_Shelf() throws OperationNotSupportedException {
        this.toyStore.addToy("A", TOY1);
        Map<String, Toy> toys = this.toyStore.getToyShelf();
        Toy toy = toys.get("A");

        Assert.assertEquals(toy.getManufacturer(), TOY1.getManufacturer());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_Try_To_Modify_Shelves_Collection() {
        this.toyStore.getToyShelf().put("H", null);
    }
}