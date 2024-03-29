package _18_UnitTesting_Exc._02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private static final Person PERSON_ONE = Mockito.mock(Person.class);
    private static final Person PERSON_TWO = Mockito.mock(Person.class);
    private static final Person PERSON_THREE = Mockito.mock(Person.class);
    private static final Person RANDOM_PERSON = Mockito.mock(Person.class);
    private static final Person[] PEOPLE = {PERSON_ONE, PERSON_TWO, PERSON_THREE};
    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.database = new Database(PEOPLE);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Storing_Array_Capacity() throws OperationNotSupportedException {
        this.database = new Database();
        this.database = new Database(new Person[17]);
    }

    @Test
    public void test_Add_Element_At_Next_Free_Cell() throws OperationNotSupportedException {
        Person person = Mockito.mock(Person.class);

        this.database.add(person);

        int lastIndex = this.database.getElements().length - 1;

        Assert.assertEquals(person, this.database.getElements()[lastIndex]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Add_Null_Element() throws OperationNotSupportedException {
        this.database.add(null);
    }

    @Test
    public void test_Remove_Element_At_Last_Index() throws OperationNotSupportedException {
        this.database.add(RANDOM_PERSON);

        this.database.remove();

        Assert.assertArrayEquals(PEOPLE, this.database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Remove_Element_From_Empty_Database() throws OperationNotSupportedException {
        this.database.remove();
        this.database.remove();
        this.database.remove();
        this.database.remove();
    }

    @Test
    public void test_Return_Elements_As_An_Array() {
        Assert.assertTrue(this.database.getElements().getClass().isArray());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Finding_Arguments_Case_Sensitivity() throws OperationNotSupportedException {
        String name = "Pesho";
        Person person = new Person(123, name);

        this.database.add(person);

        this.database.findByUsername(name.toLowerCase());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Finding_Non_Present_User() throws OperationNotSupportedException {
        this.database.findByUsername("Gosho");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Finding_Null_User() throws OperationNotSupportedException {
        String username = null;
        this.database.findByUsername(username);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Finding_By_Non_Present_ID() throws OperationNotSupportedException {
        int nonPresentId = 111;
        this.database.findById(nonPresentId);
    }
}
