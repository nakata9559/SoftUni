package _23_PastExams._2023_08_August_05.bank.entities.bank;

import _23_PastExams._2023_08_August_05.bank.common.ConstantMessages;
import _23_PastExams._2023_08_August_05.bank.entities.client.Client;

public class BranchBank extends BaseBank{
    private static final int CAPACITY = 25;

    public BranchBank(String name) {
        super(name, CAPACITY);
    }

    @Override
    public void addClient(Client client) {
        if (client.getClass().getSimpleName().equals("Student")) {
            super.addClient(client);
        } else {
            throw new IllegalArgumentException(ConstantMessages.UNSUITABLE_BANK);
        }
    }
}
