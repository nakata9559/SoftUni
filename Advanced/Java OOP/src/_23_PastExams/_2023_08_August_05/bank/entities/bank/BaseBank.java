package _23_PastExams._2023_08_August_05.bank.entities.bank;

import _23_PastExams._2023_08_August_05.bank.common.ExceptionMessages;
import _23_PastExams._2023_08_August_05.bank.entities.client.Client;
import _23_PastExams._2023_08_August_05.bank.entities.loan.Loan;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseBank implements Bank{
    private String name;
    private int capacity;
    private Collection<Loan> loans;
    private Collection<Client> clients;

    public BaseBank(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.loans = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.BANK_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public Collection<Client> getClients() {
        return this.clients;
    }

    @Override
    public Collection<Loan> getLoans() {
        return this.loans;
    }

    @Override
    public void addClient(Client client) {
        if (this.capacity > this.clients.size()) {
            this.clients.add(client);
        } else {
            throw new IllegalStateException(ExceptionMessages.NOT_ENOUGH_CAPACITY_FOR_CLIENT);
        }
    }

    @Override
    public void removeClient(Client client) {
        this.clients.remove(client);
    }

    @Override
    public void addLoan(Loan loan) {
        this.loans.add(loan);
    }

    @Override
    public int sumOfInterestRates() {
        return this.loans.stream()
                .mapToInt(Loan::getInterestRate)
                .sum();
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Name: %s, Type: %s",
                this.name,
                this.getClass().getSimpleName()));
        sb.append(System.lineSeparator());

        sb.append("Clients: ");
        String clientNames = String.join(", ", this.clients.stream()
                .map(Client::getName)
                .toArray(String[]::new));

        if (this.clients.isEmpty()) {
            sb.append("none");
        } else {
            sb.append(clientNames);
        }
        sb.append(System.lineSeparator());

        sb.append(String.format("Loans: %d, Sum of interest rates: %d",
                this.loans.size(),
                this.sumOfInterestRates()));

        return sb.toString();
    }
}
