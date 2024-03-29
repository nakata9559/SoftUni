package _23_PastExams._2023_08_August_05.bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTests {
    private static final String BANK_NAME = "DSKBank";
    private static final int BANK_CAPACITY = 2;
    private static final Client CLIENT = new Client("Gosho");
    private Bank bank;

    @Before
    public void setUp() {
        this.bank = new Bank(BANK_NAME, BANK_CAPACITY);
    }

    @Test
    public void test_Get_Correct_Bank_Name() {
        Assert.assertEquals(BANK_NAME, this.bank.getName());
    }

    @Test
    public void test_Get_Correct_Bank_Capacity() {
        Assert.assertEquals(BANK_CAPACITY, this.bank.getCapacity());
    }

    @Test(expected = NullPointerException.class)
    public void test_Set_Name_Invalid_Name() {
        new Bank(null, BANK_CAPACITY);
        new Bank("   ", BANK_CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Set_Capacity_Invalid_Capacity() {
        new Bank(BANK_NAME, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Add_Client_When_Out_Of_Capacity() {
        this.bank.addClient(CLIENT);
        this.bank.addClient(CLIENT);
        this.bank.addClient(CLIENT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Remove_Non_Existent_Client() {
        this.bank.removeClient(CLIENT.getName());
    }

    @Test
    public void test_Remove_Correct_Client() {
        this.bank.addClient(CLIENT);
        this.bank.removeClient(CLIENT.getName());

        Assert.assertEquals(0, this.bank.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Loan_Withdraw_Non_Existent_Client() {
        this.bank.loanWithdrawal(CLIENT.getName());
    }

    @Test
    public void test_Loan_Withdraw_Correct_Client(){
        this.bank.addClient(CLIENT);
        Client client = this.bank.loanWithdrawal(CLIENT.getName());

        Assert.assertFalse(client.isApprovedForLoan());
    }

    @Test
    public void test_Get_Correct_Statistics() {
        this.bank.addClient(CLIENT);
        String statistics = this.bank.statistics();

        Assert.assertEquals(statistics,
                String.format("The client %s is at the %s bank!",
                        CLIENT.getName(),
                        BANK_NAME));
    }
}
