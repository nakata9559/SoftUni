package _23_PastExams._2023_08_August_05.bank.entities.bank;

import _23_PastExams._2023_08_August_05.bank.common.ConstantMessages;
import _23_PastExams._2023_08_August_05.bank.entities.client.Client;

public class CentralBank extends BaseBank{
    private static final int CAPACITY = 50;

    public CentralBank(String name) {
        super(name, CAPACITY);
    }

    @Override
    public void addClient(Client client) {
        if (client.getClass().getSimpleName().equals("Adult")) {
            super.addClient(client);
        } else {
            throw new IllegalArgumentException(ConstantMessages.UNSUITABLE_BANK);
        }
    }
}
