package _18_UnitTesting_Exc._01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private static final Integer[] INVALID_CONSTRUCTOR_PARAMETERS = new Integer[17];
    private static final Integer[] CONSTRUCTOR_PARAMETERS = {1};
    private static final Integer ELEMENT_TO_ADD = 6;
    private static final Integer NULL_ELEMENT = null;
    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.database = new Database(CONSTRUCTOR_PARAMETERS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Storing_Array_Capacity() throws OperationNotSupportedException {
        this.database = new Database();
        this.database = new Database(INVALID_CONSTRUCTOR_PARAMETERS);
    }

    @Test
    public void test_Add_Element_At_Next_Free_Cell() throws OperationNotSupportedException {
        this.database.add(ELEMENT_TO_ADD);

        int lastIndex = this.database.getElements().length - 1;

        Assert.assertEquals(ELEMENT_TO_ADD, this.database.getElements()[lastIndex]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Add_Null_Element() throws OperationNotSupportedException {
        this.database.add(NULL_ELEMENT);
    }

    @Test
    public void test_Remove_Element_At_Last_Index() throws OperationNotSupportedException {
        this.database.add(ELEMENT_TO_ADD);

        this.database.remove();

        Assert.assertArrayEquals(CONSTRUCTOR_PARAMETERS, this.database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Remove_Element_From_Empty_Database() throws OperationNotSupportedException {
        this.database.remove();
        this.database.remove();
    }

    @Test
    public void test_Return_Elements_As_An_Array() {
        Assert.assertTrue(this.database.getElements().getClass().isArray());
    }
}
