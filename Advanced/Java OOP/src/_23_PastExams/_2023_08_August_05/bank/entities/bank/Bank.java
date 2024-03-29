package _23_PastExams._2023_08_August_05.bank.entities.bank;

import _23_PastExams._2023_08_August_05.bank.entities.client.Client;
import _23_PastExams._2023_08_August_05.bank.entities.loan.Loan;

import java.util.Collection;

public interface Bank {
    String getName();

    void setName(String name);

    Collection<Client> getClients();

    Collection<Loan> getLoans();

    void addClient(Client client);

    void removeClient(Client client);

    void addLoan(Loan loan);

    int sumOfInterestRates();

    String getStatistics();
}
