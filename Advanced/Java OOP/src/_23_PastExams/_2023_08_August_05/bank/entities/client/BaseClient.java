package _23_PastExams._2023_08_August_05.bank.entities.client;

import static _23_PastExams._2023_08_August_05.bank.common.ExceptionMessages.*;

public abstract class BaseClient implements Client {
    private String name;
    private String ID;
    private int interest;
    private double income;

    public BaseClient(String name, String ID, int interest, double income) {
        this.setName(name);
        this.setID(ID);
        this.interest = interest;
        this.setIncome(income);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(CLIENT_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public int getInterest() {
        return this.interest;
    }

    @Override
    public double getIncome() {
        return this.income;
    }

    @Override
    public void increase() {
        this.interest++;
    }

    private void setID(String ID) {
        if (ID == null || ID.trim().isEmpty()) {
            throw new IllegalArgumentException(CLIENT_ID_CANNOT_BE_NULL_OR_EMPTY);
        }

        this.ID = ID;
    }

    private void setIncome(double income) {
        if (income <= 0) {
            throw new IllegalArgumentException(CLIENT_INCOME_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }

        this.income = income;
    }
}
